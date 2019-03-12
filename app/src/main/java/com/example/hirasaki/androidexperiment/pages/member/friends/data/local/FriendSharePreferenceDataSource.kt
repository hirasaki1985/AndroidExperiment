package com.example.hirasaki.androidexperiment.pages.member.friends.data.local

import android.content.Context
import com.example.hirasaki.androidexperiment.bases.data.local.BaseSharedPreferencesParent
import java.util.*

class FriendSharePreferenceDataSource(context: Context): BaseSharedPreferencesParent(context) {
    override val file_name = "friend"
    private val key_latest_get_remote_friend_list = "latest_get_remote_friend_list"
    private val val_default = "nothing"

    fun saveLatestGetRemoteFriendList(date: Date) {
        put(key_latest_get_remote_friend_list, date.toString())
    }

    fun getLatestGetRemoteFriendList(): String? {
        return get(key_latest_get_remote_friend_list, val_default)
    }
}
