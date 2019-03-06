package com.example.hirasaki.androidexperiment.bases.data.remote

import com.example.hirasaki.androidexperiment.util.WebAPI

open class BaseRemoteDataSource() {
    private val webAPI = WebAPI()

    public fun getEndpoint(): String {
        return webAPI.endpoint_url
    }

    public fun getApiKey(): String {
        return webAPI.api_key
    }
}
