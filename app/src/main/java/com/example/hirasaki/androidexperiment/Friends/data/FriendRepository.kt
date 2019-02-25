package com.example.hirasaki.androidexperiment.friends.data

import android.util.Log
import com.example.hirasaki.androidexperiment.bases.BaseRepository
// import com.example.hirasaki.androidexperiment.bases.data.AsyncResult
import com.example.hirasaki.androidexperiment.friends.data.remote.FriendsRemoteDataSource
import org.json.JSONObject
import java.util.*
import com.example.hirasaki.androidexperiment.friends.utils.FriendsConverter

class FriendRepository: BaseRepository() {
    val friendRemoteDataSource: FriendsRemoteDataSource = FriendsRemoteDataSource()
    var cachedTasks: LinkedHashMap<String, FriendModel> = LinkedHashMap()
    var cacheIsDirty = false
    val converter = FriendsConverter()

    fun getFriendList(arg: JSONObject): List<FriendModel> {
        val result = friendRemoteDataSource.getFriendList(arg)
        Log.d("FriendsListFragment onParallelGetButtonClick()", result.toString())
        return converter.ConvertJsonToFriendModelList(result)
    }

    fun createFriend(friend: FriendModel): Int {
        val result =  friendRemoteDataSource.createFriend(friend.toObject())
        return result.get("data").toString().toInt()
    }
}
