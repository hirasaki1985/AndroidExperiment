package com.example.hirasaki.androidexperiment.login.profile.data.remote

import android.util.Log
import com.example.hirasaki.androidexperiment.bases.data.remote.BaseRemoteDataSource
import com.example.hirasaki.androidexperiment.util.Http
import org.json.JSONObject

class ProfileRemoteDataSource: BaseRemoteDataSource() {
    private val moduleName = "profile"
    private val actionMe = "me"

    fun getProfile(arg: JSONObject): JSONObject {
        val params = JSONObject()
        val http = Http()
        var result: String? =  null

        params.put("module", moduleName)
        params.put("action", actionMe)
        params.put("key", getApiKey())

        result = http.get(
            getEndpoint(),
            params
        )
        Log.d("ProfileRemoteDataSource getProfile()", result.toString())
        return JSONObject(result.toString())
    }
}
