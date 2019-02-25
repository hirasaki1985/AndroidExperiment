package com.example.hirasaki.androidexperiment.bases

import org.json.JSONObject

open class BaseModel {
    fun parse(data: Any) {

    }

    open fun convert(json: JSONObject) {

    }

    open fun toObject(): JSONObject {
        return JSONObject()
    }
}
