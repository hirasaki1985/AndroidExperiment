package com.example.hirasaki.androidexperiment.migration

import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.hirasaki.androidexperiment.bases.SQLLiteVersionManagerInterface

class SQLLiteVer02_Profile() : SQLLiteVersionManagerInterface {
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        Log.d("SQLLiteVer02_Profile onUpgrade()", "migrate start")
        // create profile table
        db?.execSQL("CREATE TABLE profile ( " +
                " _id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " name TEXT NOT NULL, " +
                " sex INTEGER NOT NULL, " +
                " birthday TEXT NOT NULL, " +
                " profile TEXT NOT NULL, " +
                " created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP)")
    }

    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        Log.d("SQLLiteVer02_Profile onDowngrade()", "migrate start")
        // drop profile table
        db?.execSQL("DROP TABLE if exists profile")
    }
}
