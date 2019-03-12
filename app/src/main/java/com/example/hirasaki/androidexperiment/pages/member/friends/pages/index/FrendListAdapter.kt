package com.example.hirasaki.androidexperiment.pages.member.friends.pages.index

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hirasaki.androidexperiment.R
import android.util.Log
import com.example.hirasaki.androidexperiment.pages.member.friends.data.FriendModel

/**
 * an Adapter for use the FriendList.
 */
class FriendListAdapter(
    context: Context?,
    private val list: List<FriendModel>,
    private val listener: ListListener
)
        : RecyclerView.Adapter<FriendListViewHolder>() {

    private val inflater = LayoutInflater.from(context)

    /**
     * Return View and ViewHolder.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendListViewHolder {
        Log.d("FriendListAdapter", "onCreateViewHolder")
        val rowView: View = LayoutInflater.from(parent.context).inflate(R.layout.member_friends_friendlist_row, parent, false)
        return FriendListViewHolder(rowView)
    }

    /**
     * Set the value to be displayed.
     */
    override fun onBindViewHolder(holder: FriendListViewHolder, position: Int) {
        Log.d("FriendListAdapter", "onBindViewHolder")
        holder.friend_name.text = list[position].name
        // holder.detailView.text = list[position].detail
        holder.itemView.setOnClickListener {
            listener.onClickRow(it, list[position])
        }
    }

    /**
     * Return list size as type of Int.
     */
    override fun getItemCount(): Int {
        Log.d("FriendListAdapter", "getItemCount")
        return list.size
    }

    interface ListListener {
        fun onClickRow(tappedView: View, rowModel: FriendModel)
    }
}
