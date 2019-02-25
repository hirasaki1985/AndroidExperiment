package com.example.hirasaki.androidexperiment.util

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

    fun ConvertJsonToFriendModel(json: JSONObject): FriendModel {
        return FriendModel(
            json.getInt("id"),
            json.get("name").toString(),
            json.get("sex").toString().toBoolean(),
            Date(json.get("birthday").toString()),
            json.get("profile").toString()
        )
    }

    fun ConvertFriendModelToObject(model: FriendModel): JSONObject {
        val params = JSONObject()
        params.put("name", model.name)
        if (model.sex) {
            params.put("sex", 1)
        } else {
            params.put("sex", 0)
        }
        params.put("birthday", df.format(model.birthday))
        params.put("profile", model.profile)

        return params
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
                    val model = ConvertJsonToFriendModel(item)
                    friendList.add(model)
                }
            }
        }

        return friendList.toList()
    }
}