package com.example.hirasaki.androidexperiment.friends.utils

import android.util.Log
import com.example.hirasaki.androidexperiment.friends.data.FriendModel
import org.json.JSONArray
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*

class FriendsConverter() {
    private val df = SimpleDateFormat("yyyy-MM-dd")

    fun ConvertStringsToModel(id: String, name: String, sex: String, birthday: String, profile: String): FriendModel {
        return FriendModel(
            id.toInt(),
            name,
            sex.toBoolean(),
            Date(birthday),
            profile
        )
    }

    fun ConvertJsonToFriendModelList(json: JSONObject): List<FriendModel> {
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
                    val model = FriendModel()
                    model.convert(item)
                    friendList.add(model)
                }
            }
        }

        return friendList.toList()
    }

    fun ConvertModelToJsonList(models: List<FriendModel>): List<JSONObject> {
        var objList = mutableListOf<JSONObject>()

        for (model in models) {
            objList.add(model.toObject())
        }
        return objList.toList()
    }
}