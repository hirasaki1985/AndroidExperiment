package com.example.hirasaki.androidexperiment.friends.data.remote

import com.example.hirasaki.androidexperiment.bases.data.remote.BaseRemoteDataSource
import com.example.hirasaki.androidexperiment.friends.data.FriendModel
import kotlinx.coroutines.*

class FriendsRemoteDataSource(): BaseRemoteDataSource() {
    //fun getFriendList(): Deferred<List<FriendModel>> = async(CommonPool) {

    // }
    fun getFriendList(): Array<FriendModel> {
        val friendList = mutableListOf<FriendModel>()

        return friendList.toTypedArray()
    }

    fun getFriend() {

    }

    fun createFriend() {

    }

    fun updateFriend() {

    }

    fun deleteFriend() {

    }
}