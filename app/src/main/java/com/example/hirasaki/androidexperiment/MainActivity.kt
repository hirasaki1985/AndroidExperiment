package com.example.hirasaki.androidexperiment

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_timeline -> {
                // message.setText(R.string.nav_title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_friends -> {
                // message.setText(R.string.nav_title_friends)
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_profile -> {
                // message.setText(R.string.nav_title_profile)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
