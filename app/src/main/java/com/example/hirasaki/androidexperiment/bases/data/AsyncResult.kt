@file:Suppress("unused")

package com.example.hirasaki.androidexperiment.bases.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.experimental.*
import kotlin.coroutines.experimental.CoroutineContext
import kotlin.coroutines.experimental.EmptyCoroutineContext

sealed class AsyncResult<out T : Any> {

    class Success<out T : Any>(val data: T) : AsyncResult<T>()

    class Error(val exception: Throwable) : AsyncResult<Nothing>()
}

/**
 * Equivalent to [launch] but return [Unit] instead of [Job].
 *
 * Mainly for usage when you want to lift [launch] to return. Example:
 *
 * ```
 * override fun loadData() = launchSilent {
 *     // code
 * }
 * ```
 */
fun launchSilent(
    context: CoroutineContext = DefaultDispatcher,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    parent: Job? = null,
    block: suspend CoroutineScope.() -> Unit
) {
    launch(context, start, parent, block)
}

/**
 * Equivalent to [runBlocking] but return [Unit] instead of [T].
 *
 * Mainly for usage when you want to lift [runBlocking] to return. Example:
 *
 * ```
 * override fun loadData() = runBlockingSilent {
 *     // code
 * }
 * ```
 */
fun <T> runBlockingSilent(context: CoroutineContext = EmptyCoroutineContext, block: suspend CoroutineScope.() -> T) {
    runBlocking(context, block)
}