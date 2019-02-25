package com.example.hirasaki.androidexperiment.friends.data

import android.util.Log
import com.example.hirasaki.androidexperiment.bases.BaseRepository
// import com.example.hirasaki.androidexperiment.bases.data.AsyncResult
import com.example.hirasaki.androidexperiment.friends.data.remote.FriendsRemoteDataSource
import com.example.hirasaki.androidexperiment.util.Http
import org.json.JSONObject
import java.util.*
import com.example.hirasaki.androidexperiment.util.FriendsConverter

class FriendRepository: BaseRepository() {
    val friendRemoteDataSource: FriendsRemoteDataSource = FriendsRemoteDataSource()
    var cachedTasks: LinkedHashMap<String, FriendModel> = LinkedHashMap()
    var cacheIsDirty = false
    val converter = FriendsConverter()

    fun getFriendList(arg: JSONObject): List<FriendModel> {
        val result = friendRemoteDataSource.getFriendList(arg)
        Log.d("FriendsListFragment onParallelGetButtonClick()", result.toString())
        return converter.ConverJsonToFriendModelList(result)
    }

    // val tasksLocalDataSource: TasksDataSource
    /*
    suspend fun getFriendList(): AsyncResult<List<FriendModel>> {
        return getFriendListFromRemoteDataSource()

        // return AsyncResult.Success(cachedTasks.values.toList())

        /*
        // Respond immediately with cache if available and not dirty
        if (cachedTasks.isNotEmpty() && !cacheIsDirty) {
            return AsyncResult.Success(cachedTasks.values.toList())
        }

        return if (cacheIsDirty) {
            // If the cache is dirty we need to fetch new data from the network.
            getFriendListFromRemoteDataSource()
        } else {
            // Query the local storage if available. If not, query the network.
            // val result = tasksLocalDataSource.getTasks()
            when (result) {
                is AsyncResult.Success -> {
                    refreshCache(result.data)
                    AsyncResult.Success(cachedTasks.values.toList())
                }
                is AsyncResult.Error -> getFriendListFromRemoteDataSource()
            }
        }
        */
    }
    */

    /*
    private suspend fun getFriendListFromRemoteDataSource(): AsyncResult<List<FriendModel>> {
        val result = friendRemoteDataSource.getFriendList()
        return when (result) {
            is AsyncResult.Success -> {
                //refreshCache(result.data)
                // refreshLocalDataSource(result.data)
                AsyncResult.Success(ArrayList(cachedTasks.values))
            }
            is AsyncResult.Error -> {
                Log.e("FriendRepository getFriendListFromRemoteDataSource()", "AsyncResult.Error")
                AsyncResult.Success(ArrayList(cachedTasks.values))
            }
            // is AsyncResult.Error -> AsyncResult.Error(RemoteDataNotFoundException())
        }
    }
    */
}
