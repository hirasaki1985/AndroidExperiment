package com.example.hirasaki.androidexperiment.friends.index

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.eclipsesource.json.Json
import com.eclipsesource.json.JsonObject
import com.example.hirasaki.androidexperiment.R
// import android.widget.Toast
import java.util.*
import com.example.hirasaki.androidexperiment.friends.data.FriendDetail.FriendsDetailFragment
import com.example.hirasaki.androidexperiment.friends.data.FriendModel
import com.example.hirasaki.androidexperiment.friends.friendinput.FriendsInputFragment
import com.example.hirasaki.androidexperiment.friends.utils.FriendPresenter
import com.example.hirasaki.androidexperiment.util.Http
import kotlinx.coroutines.*
import org.json.JSONArray
import org.json.JSONObject
import java.sql.Array

class FriendsListFragment : Fragment()  {
    private var mContext: Context? = null
    private var presenter: FriendPresenter = FriendPresenter()
    private lateinit var myView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // set Context.
        mContext = inflater.getContext()
        return inflater.inflate(R.layout.fragment_friends, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myView = view

        // tap add button.
        val addButton = view.findViewById<Button>(R.id.friend_list_add_button)

        /**
         * processing when tap add button.
         */
        addButton.setOnClickListener {
            val fragment = FriendsInputFragment()
            val fragmentManager = getFragmentManager()

            if (fragmentManager != null) {
                val fragmentTransaction = fragmentManager.beginTransaction()
                // setting BackStack
                fragmentTransaction.addToBackStack(null)

                // replace display
                fragmentTransaction.replace(R.id.frameLayout, fragment)
                fragmentTransaction.commit()
            }
        }

        reloadFriendList(presenter.getStateFriendList())

        onParallelGetButtonClick()
    }

    fun reloadFriendList(friendList: List<FriendModel>) {
        var view = myView
        val recyclerView = view.findViewById<RecyclerView>(R.id.friend_list)

        // create an adapter for use recyclerView.
        val adapter = FriendListAdapter(
            mContext,
            friendList,
            object : FriendListAdapter.ListListener {
                /**
                 * processing when items in the list are tapped.
                 */
                override fun onClickRow(tappedView: View, friendModel: FriendModel) {
                    // Toast.makeText(mContext, friendModel.name, Toast.LENGTH_SHORT).show()
                    val bundle = Bundle()
                    bundle.putInt("id", friendModel.id)

                    val fragment = FriendsDetailFragment()
                    fragment.setArguments(bundle)

                    val fragmentManager = getFragmentManager()
                    if (fragmentManager != null) {
                        val fragmentTransaction = fragmentManager.beginTransaction()
                        // setting BackStack
                        fragmentTransaction.addToBackStack(null)

                        // replace display
                        fragmentTransaction.replace(R.id.frameLayout, fragment)
                        fragmentTransaction.commit()
                    }

                    /*
                    R.id.nav_friends -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.frameLayout, fragment)
                            .commit()
                        return@OnNavigationItemSelectedListener true
                    }
                    */
                }
            })

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
    }

    //非同期処理でHTTP GETを実行します。
    fun onParallelGetButtonClick() = GlobalScope.launch(Dispatchers.Main) {
        Log.d("FriendsListFragment onParallelGetButtonClick()", "start")
        //Mainスレッドでネットワーク関連処理を実行するとエラーになるためBackgroundで実行
        async(Dispatchers.Default) {

            // get FriendList
            val params = JSONObject()
            presenter.getFriendList(params)
        }.await().let {
            // load FriendList
            reloadFriendList(it)
        }
    }
}

// fun getFriendList(): List<FriendModel> {
// suspend fun getLocalFriendList(): Deferred<List<FriendModel>> {
/*
suspend fun getLocalFriendList(): List<FriendModel> = withContext(Dispatchers.Default) {
    val params = JSONObject()
    val http = Http()

    params.put("module", "friends")
    params.put("action", "list")
    params.put("key", "tGendC3d2CMEOvsiH6UVstknFc31RM")

    http.httpGET1(
        "https://script.google.com/macros/s/AKfycbzLNFOuKp4DLbrfN0zlNAV0EyvnC1F_XZQGrVu-u7-fgIhUZ3x1/exec",
        params
    )
    //minimal-jsonを使って　jsonをパース
    val result = Json.parse(it).asObject()
    Log.d("FriendsListFragment onParallelGetButtonClick()", result.toString())

    // return@async ConverJsonDataToArray(JSONObject(result.toString()))
}
*/
