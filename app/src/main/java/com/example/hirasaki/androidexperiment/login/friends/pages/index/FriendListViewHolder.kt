package com.example.hirasaki.androidexperiment.login.friends.pages.index

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.hirasaki.androidexperiment.R
import android.widget.TextView

class FriendListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    var friend_name: TextView = itemView.findViewById(R.id.friendlist_row_friend_name)
    // val detailView: TextView = itemView.findViewById(R.id.row_detail)
}
