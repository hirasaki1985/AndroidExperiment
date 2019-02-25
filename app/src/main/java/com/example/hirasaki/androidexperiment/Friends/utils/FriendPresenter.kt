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

    /*
    fun getFriendList() = launchSilent(uiContext) {
        val result = friendRepository.getFriendList()
    }
    */
    /*
    // fun getFriendList(): List<FriendModel> {
    fun getFriendList(): Deferred<List<FriendModel>> = async(CommonPool) {
        val params = JSONObject()
        val http = Http()

        params.put("module", "friends")
        params.put("action", "list")
        params.put("key", "tGendC3d2CMEOvsiH6UVstknFc31RM")

        http.httpGET1(
            "https://script.google.com/macros/s/AKfycbzLNFOuKp4DLbrfN0zlNAV0EyvnC1F_XZQGrVu-u7-fgIhUZ3x1/exec",
            params
        ) }.await().let {

        //minimal-jsonを使って　jsonをパース
        val result = Json.parse(it).asObject()
        Log.d("FriendsListFragment onParallelGetButtonClick()", result.toString())

        return@async ConverJsonDataToArray(JSONObject(result.toString()))
    }
    */

    // fun onParallelGetButtonClick() = GlobalScope.launch(Dispatchers.Main) {
    fun create(model: FriendModel) = GlobalScope.launch(Dispatchers.Main) {
        val http = Http()
        //Mainスレッドでネットワーク関連処理を実行するとエラーになるためBackgroundで実行
        async(Dispatchers.Default) {
            val params = JSONObject()
            params.put("module", "friends")
            params.put("action", "list")
            params.put("key", "tGendC3d2CMEOvsiH6UVstknFc31RM")

            http.httpGET1(
                "https://script.google.com/macros/s/AKfycbzLNFOuKp4DLbrfN0zlNAV0EyvnC1F_XZQGrVu-u7-fgIhUZ3x1/exec",
                params
            ) }.await().let {

            //minimal-jsonを使って　jsonをパース
            val result = Json.parse(it).asObject()
            Log.d("FriendsListFragment onParallelGetButtonClick()", result.toString())

            // val textView = findViewById(R.id.text) as TextView
            // textView.setText(result.get("description").asObject().get("text").asString())
        }
    }

    public fun update(target: Int, model: FriendModel): Boolean {
        return true
    }

    public fun delete(target: Int): Boolean {
        return true
    }

    fun ConverJsonDataToArray(json: JSONObject): List<FriendModel> {
        val friendList = mutableListOf<FriendModel>()

        val keys: Iterator<String> = json.keys()
        Log.d("FriendsListFragment ConverJsonDataToArray()", "start")
        Log.d("keys = ", keys.toString())
        val datas = json.get("data")

        Log.d("datas = ", datas.toString())

        if (datas is JSONArray) {
            for (i in 0 until datas.length()) {
                Log.d("JSONArray", i.toString())
                Log.d("value", datas[i].toString())
                val item = datas[i]

                if (item is JSONObject) {
                    val model = FriendModel(
                        item.getInt("id"),
                        item.get("name").toString(),
                        item.get("sex").toString().toBoolean(),
                        Date(item.get("birthday").toString()),
                        item.get("profile").toString()
                    )
                    friendList.add(model)
                }
            }
        }

        return friendList.toList()
    }
}
