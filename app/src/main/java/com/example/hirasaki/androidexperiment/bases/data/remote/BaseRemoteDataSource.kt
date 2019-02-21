package com.example.hirasaki.androidexperiment.bases.data.remote

import com.example.hirasaki.androidexperiment.configs.WebAPI

open class BaseRemoteDataSource() {
    private val webAPI = WebAPI()

    private fun getEndpoint(): String {
        return webAPI.endpoint_url
    }
}
