package com.example.hirasaki.androidexperiment.friends.index

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.hirasaki.androidexperiment.R
// import android.widget.Toast
// import java.util.*
import com.example.hirasaki.androidexperiment.friends.data.FriendDetail.FriendsDetailFragment
import com.example.hirasaki.androidexperiment.friends.data.FriendModel
import com.example.hirasaki.androidexperiment.friends.friendinput.FriendsInputFragment
import com.example.hirasaki.androidexperiment.friends.utils.FriendPresenter

class FriendsListFragment : Fragment()  {
    private var mContext: Context? = null
    private var presenter: FriendPresenter = FriendPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // set Context.
        mContext = inflater.getContext()
        return inflater.inflate(R.layout.fragment_friends, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.friend_list)

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

        // create an adapter for use recyclerView.
        val adapter = FriendListAdapter(
            mContext,
            presenter.getFriendList(),
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
}
