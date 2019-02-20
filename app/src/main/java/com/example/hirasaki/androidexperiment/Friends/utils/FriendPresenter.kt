package com.example.hirasaki.androidexperiment.friends.utils

import com.example.hirasaki.androidexperiment.bases.BasePresenter
import com.example.hirasaki.androidexperiment.friends.data.FriendModel

class FriendPresenter: BasePresenter() {
    /**
     * Create the data that display in the recycle view.
     */
    public fun getFriendList(): List<FriendModel> {
        val dataList = mutableListOf<FriendModel>()
        for (i in 0..49) {
            val data: FriendModel = FriendModel()
                .also {
                    it.id = i
                    it.name = "タイトル" + i + "だよ"
                }
            dataList.add(data)
        }
        return dataList
    }
}
