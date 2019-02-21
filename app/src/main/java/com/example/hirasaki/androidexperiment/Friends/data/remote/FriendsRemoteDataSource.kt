package com.example.hirasaki.androidexperiment.friends.data.remote

import com.example.hirasaki.androidexperiment.bases.data.remote.BaseRemoteDataSource
import com.example.hirasaki.androidexperiment.friends.data.FriendModel
import kotlinx.coroutines.*

class FriendsRemoteDataSource(): BaseRemoteDataSource() {
    // suspend fun getFriendList(): Deferred<List<FriendModel>> = async {
    // fun getFriendList(): List<FriendModel> = async {

    suspend fun getStateFriendList(): List<FriendModel> {
    // suspend fun getFriendList(): Deferred<List<FriendModel>> {
        val friendList = mutableListOf<FriendModel>()

        return friendList.toList()
    }

    /*
    suspend fun getFriendList(): List<FriendModel> = withContext(Dispatchers.Default) {
        //API呼び出し()  // List<Item> を返す
        val friendList = mutableListOf<FriendModel>()
        return friendList
    }
     */

    fun getFriend() {
    }

    fun createFriend() {

    }

    fun updateFriend() {

    }

    fun deleteFriend() {

    }
}
