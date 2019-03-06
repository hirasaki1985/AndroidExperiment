package com.example.hirasaki.androidexperiment.migration

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.hirasaki.androidexperiment.bases.SQLLiteVersionManagerInterface

private const val DB_NAME = "SampleDatabase"
private const val DB_VERSION = 3

class SQLLiteManager(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    val ver02: SQLLiteVersionManagerInterface = SQLLiteVer02_Profile()
    val ver03: SQLLiteVersionManagerInterface = SQLLiteVer03_UpdateFriends()

    override fun onCreate(db: SQLiteDatabase?) {
        Log.d("SQLLiteManager onCreate()", "start")
        val ver01 = SQLLiteVer01_Friends()
        ver01.onUpgrade(db, 1, 1)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        Log.d("SQLLiteManager onUpgrade()", "start")
        Log.d("SQLLiteManager oldVersion()", oldVersion.toString())
        Log.d("SQLLiteManager newVersion()", newVersion.toString())

        if (oldVersion < newVersion) {
            for (i in oldVersion + 1..newVersion) {
                when (i) {
                    2 -> ver02.onUpgrade(db, oldVersion, newVersion)
                    3 -> ver03.onUpgrade(db, oldVersion, newVersion)
                }
            }
        }
        /*else {
            for (i in newVersion .. oldVersion + 1) {
                when(i) {
                    2 -> ver02.onDowngrade(db, oldVersion, newVersion)
                    3 -> ver03.onDowngrade(db, oldVersion, newVersion)
                }
            }
        }
        */
    }
    override fun onDowngrade (db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        Log.d("SQLLiteManager onDowngrade()", "start")
        Log.d("SQLLiteManager oldVersion()", oldVersion.toString())
        Log.d("SQLLiteManager newVersion()", newVersion.toString())

        for (i in oldVersion .. newVersion + 1) {
            when (i) {
                2 -> ver02.onDowngrade(db, oldVersion, newVersion)
                3 -> ver03.onDowngrade(db, oldVersion, newVersion)
            }
        }
    }
}
