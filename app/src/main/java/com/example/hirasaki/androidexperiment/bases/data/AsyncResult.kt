@file:Suppress("unused")

package com.example.hirasaki.androidexperiment.bases.data

sealed class AsyncResult<out T : Any> {

    class Success<out T : Any>(val data: T) : AsyncResult<T>()

    class Error(val exception: Throwable) : AsyncResult<Nothing>()
}
