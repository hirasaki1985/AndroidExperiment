package com.example.hirasaki.androidexperiment.friends.data

import android.content.Context
import android.util.Log
import com.example.hirasaki.androidexperiment.bases.BaseRepository
import com.example.hirasaki.androidexperiment.friends.data.local.FriendSQLLiteDataSource
import com.example.hirasaki.androidexperiment.friends.data.local.FriendSharePreferenceDataSource
// import com.example.hirasaki.androidexperiment.bases.data.AsyncResult
import com.example.hirasaki.androidexperiment.friends.data.remote.FriendsRemoteDataSource
import org.json.JSONObject
import java.util.*
import com.example.hirasaki.androidexperiment.friends.utils.FriendsConverter

class FriendRepository(context: Context): BaseRepository() {
    private val friendRemoteDataSource: FriendsRemoteDataSource = FriendsRemoteDataSource()
    private var friendLocalSQLLiteDataSource: FriendSQLLiteDataSource? = null
    private var friendSharePreferenceDataSource: FriendSharePreferenceDataSource? = null
    private var cachedTasks: LinkedHashMap<String, FriendModel> = LinkedHashMap()
    private var cacheIsDirty = false
    private val converter = FriendsConverter()

    init {
        friendLocalSQLLiteDataSource = FriendSQLLiteDataSource(context)
        friendSharePreferenceDataSource = FriendSharePreferenceDataSource(context)
    }

    fun getRemoteFriendList(arg: JSONObject): List<FriendModel> {
        Log.d("FriendRepository getRemoteFriendList()", "start")
        Log.d("FriendRepository latest get to remote date.", friendSharePreferenceDataSource!!.getLatestGetRemoteFriendList())
        val result = friendRemoteDataSource.getFriendList(arg)
        Log.d("FriendRepository getRemoteFriendList()", result.toString())

        friendSharePreferenceDataSource!!.saveLatestGetRemoteFriendList(Date())
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
        /*
        var count = 0

        for (model in friendList) {
            val result = insertFriendList(model)
            Log.d("FriendRepository insert result", result.toString())
            count++
        }

        return count
        */
        if (friendLocalSQLLiteDataSource != null) {
            return friendLocalSQLLiteDataSource!!.merge(converter.ConvertModelToJsonList(friendList))
        }
        return -1
    }

    fun insertFriendList(friend: FriendModel): Long {
        if (friendLocalSQLLiteDataSource != null) {
            return friendLocalSQLLiteDataSource!!.insert(friend.toObject())
        }
        return -1
    }
}
