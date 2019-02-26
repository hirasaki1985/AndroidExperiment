package com.example.hirasaki.androidexperiment.bases.data.local

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

open class BaseSharedPreferencesParent(context: Context) {
    open val file_name = "base"
    private val pref = context.getSharedPreferences(file_name, Context.MODE_PRIVATE)

    fun get(key: String, def_val: String): String? {
        Log.d("BaseSharedPreferencesParent get()", "start")
        Log.d("BaseSharedPreferencesParent get() filename, key, def_val", "$file_name,$key,$def_val")

        return pref.getString(key, def_val)
    }

    fun put(key: String, value: String) {
        Log.d("BaseSharedPreferencesParent put()", "start")
        Log.d("BaseSharedPreferencesParent put() filename, key, value", "$file_name,$key,$value")
        pref.edit().putString(key, value).apply()
    }
}
