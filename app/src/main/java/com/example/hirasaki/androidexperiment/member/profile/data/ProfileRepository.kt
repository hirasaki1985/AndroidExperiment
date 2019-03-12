package com.example.hirasaki.androidexperiment.member.profile.data

import android.util.Log
import com.example.hirasaki.androidexperiment.bases.BaseRepository
import com.example.hirasaki.androidexperiment.member.profile.data.remote.ProfileRemoteDataSource
import org.json.JSONObject

class ProfileRepository(): BaseRepository() {
    private val remoteDataSource = ProfileRemoteDataSource()

    fun getProfile(arg: JSONObject): ProfileModel {
        val result = remoteDataSource.getProfile(arg)
        Log.d("ProfileRepository getProfile()", result.toString())
        var profile = ProfileModel()
        profile.convert(getData(result))

        return profile
    }
}
