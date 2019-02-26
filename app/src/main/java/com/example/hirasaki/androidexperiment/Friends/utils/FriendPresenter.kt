package com.example.hirasaki.androidexperiment.friends.utils

import android.content.Context
import android.util.Log
import com.eclipsesource.json.Json
import com.example.hirasaki.androidexperiment.bases.BasePresenter
import com.example.hirasaki.androidexperiment.friends.data.FriendModel
import com.example.hirasaki.androidexperiment.friends.data.FriendRepository
import com.example.hirasaki.androidexperiment.util.Http
import kotlinx.coroutines.*
import org.json.JSONArray
import org.json.JSONObject
import java.util.*

class FriendPresenter(context: Context): BasePresenter() {
    private val repository: FriendRepository = FriendRepository(context)

    /**
     * Create the data that display in the recycle view.
     */
    public fun getStateFriendList(): List<FriendModel> {
        val dataList = mutableListOf<FriendModel>()
        return dataList
    }

    fun getFriendList(arg: JSONObject): List<FriendModel> {
        val remote = true

        val friendList = repository.getRemoteFriendList(arg)
        val result = repository.insertLocalFriendList(friendList)
        return friendList
    }

    // fun onParallelGetButtonClick() = GlobalScope.launch(Dispatchers.Main) {
    fun create(model: FriendModel): Int {
        return repository.createFriend(model)
    }

    public fun update(target: Int, model: FriendModel): Boolean {
        return true
    }

    public fun delete(target: Int): Boolean {
        return true
    }
}
