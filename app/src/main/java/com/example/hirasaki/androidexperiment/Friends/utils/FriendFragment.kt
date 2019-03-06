package com.example.hirasaki.androidexperiment.friends.utils

import android.support.v4.app.Fragment
import com.example.hirasaki.androidexperiment.friends.data.FriendModel

open class FriendFragment(): Fragment(), FriendContract.View  {
    override fun showFriendList(response: List<FriendModel>) {

    }

    override fun showCreateResult(response: FriendModel) {

    }


    override fun showError(message: String) {
    }
}