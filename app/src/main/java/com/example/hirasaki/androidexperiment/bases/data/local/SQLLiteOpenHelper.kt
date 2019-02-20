package com.example.hirasaki.androidexperiment.bases.data.local

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

private const val DB_NAME = "SampleDatabase"
private const val DB_VERSION = 1

class SampleDBOpenHelper(context: Context) : SQLiteOpenHelper(context,
    DB_NAME, null,
    DB_VERSION
) {
    override fun onCreate(db: SQLiteDatabase?) {
        // create table
        db?.execSQL("CREATE TABLE texts ( " +
                " _id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " text TEXT NOT NULL, " +
                " created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // SQL issuance at version update
    }
}
