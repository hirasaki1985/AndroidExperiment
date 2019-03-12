package com.example.hirasaki.androidexperiment.pages.member.profile.utils

import com.example.hirasaki.androidexperiment.bases.BasePresenter
import com.example.hirasaki.androidexperiment.pages.member.profile.data.ProfileModel
import com.example.hirasaki.androidexperiment.pages.member.profile.data.ProfileRepository
import com.example.hirasaki.androidexperiment.util.Http
import com.squareup.picasso.RequestCreator
import org.json.JSONObject

class ProfilePresenter: BasePresenter() {
    private val repository: ProfileRepository = ProfileRepository()
    private val http: Http = Http()

    fun getProfile(arg: JSONObject): ProfileModel {
        return repository.getProfile(arg)
    }

    fun getProfileImage(model: ProfileModel): RequestCreator? {
        return http.getImage(model.icon)
    }
}
