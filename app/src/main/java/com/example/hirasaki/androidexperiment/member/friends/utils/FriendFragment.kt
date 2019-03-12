package com.example.hirasaki.androidexperiment.member.friends.utils

import com.example.hirasaki.androidexperiment.bases.fragments.BaseLoginFragment
import com.example.hirasaki.androidexperiment.member.friends.data.FriendModel

open class FriendFragment(): BaseLoginFragment(), FriendContract.View  {
    override fun showFriendList(response: List<FriendModel>) {

    }

    override fun showCreateResult(response: FriendModel) {

    }


    override fun showError(message: String) {
    }
}