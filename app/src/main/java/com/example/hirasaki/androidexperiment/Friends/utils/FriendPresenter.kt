package com.example.hirasaki.androidexperiment.friends.utils

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

class FriendPresenter: BasePresenter() {
    private val friendRepository: FriendRepository = FriendRepository()
    /**
     * Create the data that display in the recycle view.
     */
    public fun getStateFriendList(): List<FriendModel> {
        val dataList = mutableListOf<FriendModel>()
        for (i in 0..49) {
            val data: FriendModel = FriendModel()
                .also {
                    it.id = i
                    it.name = "タイトル" + i + "だよ"
                }
            dataList.add(data)
        }
        return dataList
    }

    fun getFriendList(arg: JSONObject): List<FriendModel> {
        return friendRepository.getFriendList(arg)
    }

    // fun onParallelGetButtonClick() = GlobalScope.launch(Dispatchers.Main) {
    fun create(model: FriendModel): Int {
        return friendRepository.createFriend(model)
    }

    public fun update(target: Int, model: FriendModel): Boolean {
        return true
    }

    public fun delete(target: Int): Boolean {
        return true
    }
}
