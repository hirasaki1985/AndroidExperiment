package com.example.hirasaki.androidexperiment.friends.utils

import android.util.Log
import com.eclipsesource.json.Json
import com.example.hirasaki.androidexperiment.bases.BasePresenter
import com.example.hirasaki.androidexperiment.friends.data.FriendModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import com.example.hirasaki.androidexperiment.util.Http
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject

class FriendPresenter: BasePresenter() {
    /**
     * Create the data that display in the recycle view.
     */
    public fun getFriendList(): List<FriendModel> {
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
}
