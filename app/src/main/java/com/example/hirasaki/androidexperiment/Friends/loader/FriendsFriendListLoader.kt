package com.example.hirasaki.androidexperiment.friends.loader

import android.content.Context
import android.content.AsyncTaskLoader
import com.example.hirasaki.androidexperiment.configs.WebAPI
import com.example.hirasaki.androidexperiment.friends.data.FriendModel
import com.example.hirasaki.androidexperiment.friends.data.remote.FriendsRemoteDataSource

class FriendsFriendListLoader(context: Context): AsyncTaskLoader<FriendModel>(context) {
    private var cache: FriendModel? = null
    private var webAPI = WebAPI()
    private var remoteDataSource = FriendsRemoteDataSource()

    override fun loadInBackground(): FriendModel? {
        // HTTPでRSSのXMLを取得する
        val response = remoteDataSource.getFriendList()

        if (response != null) {
            // 取得に成功したら、パースして返す
            val friendModel = FriendModel()
            // return friendModel.parse(response)
            return friendModel
        }

        return null
    }

    // コールバッククラスに返す前に通る処理
    override fun deliverResult(data: FriendModel?) {
        // 破棄されていたら結果を返さない
        if (isReset || data == null) return

        // 結果をキャッシュする
        cache = data
        super.deliverResult(data)
    }

    // バックグラウンド処理が開始される前に呼ばれる
    override fun onStartLoading() {
        // キャッシュがあるなら、キャッシュを返す
        if (cache != null) {
            deliverResult(cache)
        }

        // コンテンツが変化している場合やキャッシュがない場合には、バックグラウンド処理を行う
        if (takeContentChanged() || cache == null) {
            forceLoad()
        }
    }

    // ローダーが停止する前に呼ばれる処理
    override fun onStopLoading() {
        cancelLoad()
    }

    // ローダーが破棄される前に呼ばれる処理
    override fun onReset() {
        super.onReset()
        onStopLoading()
        cache = null
    }
}