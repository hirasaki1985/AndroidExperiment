package com.example.hirasaki.androidexperiment.friends.data.remote

// import com.example.hirasaki.androidexperiment.bases.data.AsyncResult
import android.util.Log
import com.example.hirasaki.androidexperiment.bases.data.remote.BaseRemoteDataSource
import com.example.hirasaki.androidexperiment.friends.data.FriendModel
import com.example.hirasaki.androidexperiment.util.Http
import kotlinx.coroutines.*
import org.json.JSONObject

class FriendsRemoteDataSource(): BaseRemoteDataSource() {
    private val moduleName = "friends"
    private val actionList = "list"
    private val actionCreate = "create"

    fun getFriendList(arg: JSONObject): JSONObject {
        val params = JSONObject()
        val http = Http()
        var result: String? =  null

        params.put("module", moduleName)
        params.put("action", actionList)
        params.put("key", getApiKey())

        result = http.get(
            getEndpoint(),
            params
        )
        Log.d("FriendsRemoteDataSource getFriendList()", result.toString())
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

    fun createFriend(data: JSONObject): JSONObject {
        val params = JSONObject()
        val http = Http()
        var result: String? =  null

        params.put("module", moduleName)
        params.put("action", actionCreate)
        params.put("key", getApiKey())
        params.put("data", data)

        result = http.post(
            getEndpoint(),
            params
        )
        Log.d("FriendsRemoteDataSource createFriend()", result.toString())
        return JSONObject(result.toString())
    }

    fun updateFriend() {

    }

    fun deleteFriend() {

    }
}
