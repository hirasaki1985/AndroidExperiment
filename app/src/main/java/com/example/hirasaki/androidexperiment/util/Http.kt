package com.example.hirasaki.androidexperiment.util

import android.graphics.Bitmap
import android.util.Log
import okhttp3.*
import java.net.URL
import javax.net.ssl.HttpsURLConnection
import org.json.JSONObject
import android.graphics.BitmapFactory
import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator
import java.io.*


class Http {
    private val bodyType_json = "application/json; charset=utf-8"

    //叩きたいREST APIのURLを引数とします
    fun get(url: String, params: JSONObject): String? {
        Log.d("Http.get()", "start")
        Log.d("Http.get() url = ", url)
        Log.d("Http.get() params = ", params.toString())

        // params
        // val postBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params.toString())
        val uri = convertJsonToParams(params)
        val request_url = url + '?' + uri
        Log.d("Http.get() request_url", request_url)

        // create client instance
        val client = OkHttpClient()

        // create request
        // val request: Request = Request.Builder().url(request_url).get(postBody).build()
        val request: Request = Request.Builder().url(request_url).get().build()

        // execute
        val response = client.newCall(request).execute()
        /*
        val request = Request.Builder()
            // .header("Authorization", "your token")
            .url(url)
            .build()

        val response = client.newCall(request).execute()
        */
        return response.body()?.string()
    }

    fun post(url: String, params: JSONObject, type:String = "json"): String? {
        Log.d("Http.post()", "start")
        Log.d("Http.post() url = ", url)
        Log.d("Http.post() params = ", params.toString())

        // type
        val mediaType = MediaType.parse(bodyType_json)

        // params
        val postBody = RequestBody.create(mediaType, params.toString())

        // create client instance
        val client = OkHttpClient()

        // create request
        // val request: Request = Request.Builder().url(request_url).get(postBody).build()
        val request: Request = Request.Builder().url(url).post(postBody).build()

        // execute
        val response = client.newCall(request).execute()
        /*
        val request = Request.Builder()
            // .header("Authorization", "your token")
            .url(url)
            .build()

        val response = client.newCall(request).execute()
        */
        return response.body()?.string()
    }

    fun getImage(url:String): RequestCreator? {
        return Picasso.get().load(url)
    }

    /*
    fun getImage(url: String): Bitmap {
        var bitmap: Bitmap? = null
        var `in`: InputStream? = null
        var out: BufferedOutputStream? = null

        try {
            `in` = BufferedInputStream(URL(url).openStream(), IO_BUFFER_SIZE)

            val dataStream = ByteArrayOutputStream()
            out = BufferedOutputStream(dataStream, IO_BUFFER_SIZE)
            copy(`in`, out)
            out!!.flush()

            val data = dataStream.toByteArray()
            val options = BitmapFactory.Options()
            //options.inSampleSize = 1;

            bitmap = BitmapFactory.decodeByteArray(data, 0, data.size, options)
        } catch (e: IOException) {
            Log.e("Http getImage()", "Could not load Bitmap from: $url")
        } finally {
            closeStream(`in`)
            closeStream(out)
        }

        return bitmap
    }
    */

    private fun convertJsonToParams(json: JSONObject): String {
        Log.d("httpGET1 convertJsonToParams()", "start")
        var result = ""
        val keys: Iterator<String> = json.keys()

        while (keys.hasNext()) {
            val key = keys.next()
            val value = json.get(key)
            result = "$result$key=$value"

            if (value is JSONObject) {
                // result += key + "=" + json.get(key)
            }

            if (keys.hasNext()) {
                result += "&"
            }
        }
        return result
    }
}

/*
fun httpGet(url: String): InputStream? {

    // 通信接続用のオブジェクトを作る
    val con = URL(url).openConnection() as HttpsURLConnection

    // 接続の設定を行う
    con.apply {
        requestMethod = "GET"           // メソッド
        connectTimeout = 3000           // 接続のタイムアウト（ミリ秒）
        readTimeout = 5000              // 読み込みのタイムアウト（ミリ秒）
        instanceFollowRedirects = true  // リダイレクト許可
    }

    // 接続する
    con.connect()

    // ステータスコードの確認
    if (con.responseCode in 200..299) {
        // 成功したら、レスポンスの入力ストリームを、BufferedInputStreamとして返す
        return BufferedInputStream(con.inputStream)
    }

    // 失敗
    return null
}
*/
