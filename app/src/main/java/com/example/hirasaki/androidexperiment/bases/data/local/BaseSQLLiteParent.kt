package com.example.hirasaki.androidexperiment.bases.data.local

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.hirasaki.androidexperiment.migration.SQLLiteManager
import org.json.JSONObject

private const val DB_NAME = "SampleDatabase"
private const val DB_VERSION = 1

open class BaseSQLLiteParent(context: Context) {
    private val writable_db = SQLLiteManager(context).writableDatabase

    open public fun insert(table_name: String, params: JSONObject): Long {
        Log.d("BaseSQLLiteParent insert()", "start")
        Log.d("BaseSQLLiteParent table_name", table_name)
        Log.d("BaseSQLLiteParent params", params.toString())


        val keys = params.keys()
        var values = ContentValues()

        while (keys.hasNext()) {
            val key = keys.next()
            values.put(key, params.getString(key))
        }
        Log.d("BaseSQLLiteParent values", values.toString())
        return writable_db.insert(table_name, null, values)
    }
}
