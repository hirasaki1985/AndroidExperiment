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

    open public fun deleteAll(table_name: String): Int {
        Log.d("BaseSQLLiteParent deleteAl()", table_name)
        return writable_db.delete(table_name, "", arrayOf())
    }

    open public fun merge(table_name: String, params: List<JSONObject>): Int {
        Log.d("BaseSQLLiteParent merge()", table_name)
        val rel_result = deleteAll(table_name)
        Log.d("rel_result", rel_result.toString())

        var count = 0
        for (i in params) {
            insert(table_name, i)
            count++
        }

        return count
    }
}
