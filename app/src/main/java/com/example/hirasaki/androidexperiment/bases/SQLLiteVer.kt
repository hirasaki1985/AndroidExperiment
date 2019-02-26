package com.example.hirasaki.androidexperiment.bases

import android.database.sqlite.SQLiteDatabase

interface SQLLiteVer {
    fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int)
    fun onDowngrade (db: SQLiteDatabase?, oldVersion: Int, newVersion: Int)
}