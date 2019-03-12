package com.example.hirasaki.androidexperiment.pages.member.friends.data.local

import android.content.Context
import com.example.hirasaki.androidexperiment.bases.data.local.BaseSQLLiteParent
import org.json.JSONObject

class FriendSQLLiteDataSource(context: Context): BaseSQLLiteParent(context) {
    private val table_name = "friends"

    fun insert(params: JSONObject): Long {
        return super.insert(table_name, params)
    }

    fun merge(params: List<JSONObject>): Int {
        return super.merge(table_name, params)
    }
}
