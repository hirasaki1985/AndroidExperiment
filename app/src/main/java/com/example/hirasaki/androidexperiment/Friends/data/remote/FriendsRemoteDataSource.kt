package com.example.hirasaki.androidexperiment.friends.data.remote

// import com.example.hirasaki.androidexperiment.bases.data.AsyncResult
import android.util.Log
import com.example.hirasaki.androidexperiment.bases.data.remote.BaseRemoteDataSource
import com.example.hirasaki.androidexperiment.friends.data.FriendModel
import com.example.hirasaki.androidexperiment.util.Http
import kotlinx.coroutines.*
import org.json.JSONObject

class FriendsRemoteDataSource(): BaseRemoteDataSource() {
    fun getFriendList(arg: JSONObject): JSONObject {
        val params = JSONObject()
        val http = Http()
        var result: String? =  null

        params.put("module", "friends")
        params.put("action", "list")
        params.put("key", getApiKey())

        result = http.httpGET1(
            getEndpoint(),
            params
        )
        Log.d("FriendsListFragment onParallelGetButtonClick()", result.toString())
        return JSONObject(result.toString())
    }

    // suspend fun getFriendList(): Deferred<List<FriendModel>> = async {
    // fun getFriendList(): List<FriendModel> = async {

    /*
    suspend fun getFriendList(): AsyncResult<List<FriendModel>> {
    // suspend fun getFriendList(): Deferred<List<FriendModel>> {
        val friendList = mutableListOf<FriendModel>()

        return AsyncResult.Success(friendList.toList())
    }
    */

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
