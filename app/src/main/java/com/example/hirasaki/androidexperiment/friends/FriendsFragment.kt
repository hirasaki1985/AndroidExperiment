package com.example.hirasaki.androidexperiment.friends

import android.content.Context
// import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hirasaki.androidexperiment.R
// import android.widget.Toast
import com.example.hirasaki.androidexperiment.Models.FriendModel
// import java.util.*
import android.widget.Toast


class FriendsFragment : Fragment() {
    private var mContext: Context? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // set Context.
        mContext = inflater.getContext()
        return inflater.inflate(R.layout.fragment_friends, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.friend_list)

        // create an adapter for use recyclerView.
        val adapter = FriendListAdapter(mContext, createDataList(), object : FriendListAdapter.ListListener {
            /**
             * processing when items in the list are tapped.
             */
            override fun onClickRow(tappedView: View, friendModel: FriendModel) {
                // this.onClickRow(tappedView, friendModel)
                Toast.makeText(mContext, friendModel.name, Toast.LENGTH_SHORT).show()
            }
        })

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
    }

    /**
     * Create the data that display in the recycle view.
     */
    private fun createDataList(): List<FriendModel> {
        val dataList = mutableListOf<FriendModel>()
        for (i in 0..49) {
            val data: FriendModel = FriendModel().also {
                it.name = "タイトル" + i + "だよ"
            }
            dataList.add(data)
        }
        return dataList
    }
}
