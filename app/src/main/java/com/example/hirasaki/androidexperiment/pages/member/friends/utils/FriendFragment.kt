package com.example.hirasaki.androidexperiment.pages.member.friends.utils

import com.example.hirasaki.androidexperiment.bases.fragments.BaseMemberFragment
import com.example.hirasaki.androidexperiment.pages.member.friends.data.FriendModel

open class FriendFragment(): BaseMemberFragment(), FriendContract.View  {
    override fun showFriendList(response: List<FriendModel>) {

    }

    override fun showCreateResult(response: FriendModel) {

    }


    override fun showError(message: String) {
    }
}