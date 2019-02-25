package com.example.hirasaki.androidexperiment.bases

import com.eclipsesource.json.JsonObject
import org.json.JSONArray
import org.json.JSONObject

open class BaseRepository {
    fun getData(obj: JSONObject): JSONObject {
        return obj.getJSONObject("data")
    }
}
