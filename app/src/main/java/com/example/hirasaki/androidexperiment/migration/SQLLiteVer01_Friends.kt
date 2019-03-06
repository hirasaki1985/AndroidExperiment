package com.example.hirasaki.androidexperiment.migration

import android.database.sqlite.SQLiteDatabase
import android.util.Log
import com.example.hirasaki.androidexperiment.bases.SQLLiteVersionManagerInterface

class SQLLiteVer01_Friends(): SQLLiteVersionManagerInterface {
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        Log.d("SQLLiteVer01_Friends onUpgrade()", "migrate start")
        // create friend table
        db?.execSQL("CREATE TABLE friends ( " +
                " _id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " name TEXT NOT NULL, " +
                " sex INTEGER NOT NULL, " +
                " birthday TEXT NOT NULL, " +
                " profile TEXT NOT NULL, " +
                " created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP)")
    }

    override fun onDowngrade (db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        Log.d("SQLLiteVer01_Friends onDowngrade()", "migrate start")
        // drop friend table
        db?.execSQL("DROP TABLE friends")
    }
}
