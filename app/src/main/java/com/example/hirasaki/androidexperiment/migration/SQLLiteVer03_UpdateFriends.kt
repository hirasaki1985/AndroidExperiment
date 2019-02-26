package com.example.hirasaki.androidexperiment.migration

import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.hirasaki.androidexperiment.bases.SQLLiteVer

class SQLLiteVer03_UpdateFriends: SQLLiteVer {
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        Log.d("SQLLiteVer03_UpdateFriends onUpgrade()", "migrate start")
        db?.execSQL("delete from friends")
        db?.execSQL("DROP TABLE IF EXISTS friends")

        db?.execSQL("CREATE TABLE friends ( " +
                " id INTEGER PRIMARY KEY, " +
                " name TEXT NOT NULL, " +
                " sex INTEGER NOT NULL, " +
                " birthday TEXT NOT NULL, " +
                " profile TEXT NOT NULL, " +
                " created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP)")
    }

    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        Log.d("SQLLiteVer03_UpdateFriends onDowngrade()", "migrate start")
        db?.execSQL("DROP TABLE IF EXISTS friends")
        db?.execSQL("CREATE TABLE friends ( " +
                " _id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " name TEXT NOT NULL, " +
                " sex INTEGER NOT NULL, " +
                " birthday TEXT NOT NULL, " +
                " profile TEXT NOT NULL, " +
                " created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP)")
    }

}