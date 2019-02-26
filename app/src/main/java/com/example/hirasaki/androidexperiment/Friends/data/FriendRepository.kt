package com.example.hirasaki.androidexperiment.friends.data

import android.content.Context
import android.util.Log
import com.example.hirasaki.androidexperiment.bases.BaseRepository
import com.example.hirasaki.androidexperiment.friends.data.local.FriendSQLLiteDataSource
// import com.example.hirasaki.androidexperiment.bases.data.AsyncResult
import com.example.hirasaki.androidexperiment.friends.data.remote.FriendsRemoteDataSource
import org.json.JSONObject
import java.util.*
import com.example.hirasaki.androidexperiment.friends.utils.FriendsConverter

class FriendRepository(context: Context): BaseRepository() {
    val friendRemoteDataSource: FriendsRemoteDataSource = FriendsRemoteDataSource()
    var friendLocalSQLLiteDataSource: FriendSQLLiteDataSource? = null
    var cachedTasks: LinkedHashMap<String, FriendModel> = LinkedHashMap()
    var cacheIsDirty = false
    val converter = FriendsConverter()

    init {
        friendLocalSQLLiteDataSource = FriendSQLLiteDataSource(context)
    }

    fun getRemoteFriendList(arg: JSONObject): List<FriendModel> {
        val result = friendRemoteDataSource.getFriendList(arg)
        Log.d("FriendRepository getRemoteFriendList()", result.toString())
        return converter.ConvertJsonToFriendModelList(result)
    }

    fun getLocalFriendList(arg: JSONObject): List<FriendModel> {
        val result = friendRemoteDataSource.getFriendList(arg)
        Log.d("FriendRepository getLocalFriendList()", result.toString())
        return converter.ConvertJsonToFriendModelList(result)
    }

    fun createFriend(friend: FriendModel): Int {
        val result =  friendRemoteDataSource.createFriend(friend.toObject())
        return result.get("data").toString().toInt()
    }

    fun insertLocalFriendList(friendList: List<FriendModel>): Int {
        Log.d("FriendRepository insertLocalFriendList()", "start")
        var count = 0

        for (model in friendList) {
            val result = insertFriendList(model)
            Log.d("FriendRepository insert result", result.toString())
            count++
        }

        return count
    }

    fun insertFriendList(friend: FriendModel): Long {
        if (friendLocalSQLLiteDataSource != null) {
            return friendLocalSQLLiteDataSource!!.insert(friend.toObject())
        }
        return -1
    }
}
