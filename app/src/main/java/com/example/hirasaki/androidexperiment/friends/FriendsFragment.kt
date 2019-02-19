package com.example.hirasaki.androidexperiment.friends

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hirasaki.androidexperiment.R
import android.widget.Toast
import java.util.*


class FriendsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // super.onCreate(savedInstanceState)
        // setContentView(R.layout.fragment_friends)

        /*
        // RecyclerViewをレイアウトから探す
        val recyclerView = findViewById<RecyclerView>(R.id.timeZoneList)

        // タイムゾーンリスト用のアダプター
        val adapter = SampleAdapter(this) { timeZone ->
            // タップされた位置にあるタイムゾーンをトースト表示する
            Toast.makeText(this, timeZone.displayName, Toast.LENGTH_SHORT).show()
        }

        // RecyclerViewにアダプターをセットする
        recyclerView.adapter = adapter

        // 縦に直線的に表示するレイアウトマネージャ
        recyclerView.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false)
        */
        return inflater.inflate(R.layout.fragment_friends, container, false)
    }
}
