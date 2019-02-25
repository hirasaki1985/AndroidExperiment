package com.example.hirasaki.androidexperiment.util

import android.util.Log
import com.example.hirasaki.androidexperiment.friends.data.FriendModel
import org.json.JSONArray
import org.json.JSONObject
import java.util.*

class FriendsConverter() {
    fun ConverJsonToFriendModelList(json: JSONObject): List<FriendModel> {
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