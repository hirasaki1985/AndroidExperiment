package com.example.hirasaki.androidexperiment.friends.utils

import android.content.Context
import android.util.Log
import com.example.hirasaki.androidexperiment.bases.BasePresenter
import com.example.hirasaki.androidexperiment.friends.data.FriendModel
import com.example.hirasaki.androidexperiment.friends.data.FriendRepository
import kotlinx.coroutines.*
import org.json.JSONObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FriendPresenter(context: Context, parentView: FriendContract.View): BasePresenter(), FriendContract.UserActions {
    private val action_view: FriendContract.View = parentView;
    private val repository: FriendRepository = FriendRepository(context)

    override fun fetchFriendList() = GlobalScope.launch(Dispatchers.Main) {
        Log.d("FriendPresenter onGetFriendList()", "start")
        async(Dispatchers.Default) {

            // get FriendList
            val params = JSONObject()
            getFriendList(params)
        }.await().let {
            action_view.showFriendList(it)
        }
    }

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
    fun create(model: FriendModel) = GlobalScope.launch(Dispatchers.Main) {
        Log.d("FriendPresenter create()", "start")
        async(Dispatchers.Default) {
            repository.createFriend(model)
        }.await().let {
            model.id = it
            action_view.showCreateResult(model)
        }
    }
}
