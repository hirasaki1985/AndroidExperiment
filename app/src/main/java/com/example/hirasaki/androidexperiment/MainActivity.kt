package com.example.hirasaki.androidexperiment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.example.hirasaki.androidexperiment.bases.activities.BasePublicActivity
import com.example.hirasaki.androidexperiment.pages.member.MemberMainActivity
import com.example.hirasaki.androidexperiment.pages.publics.PublicMainActivity

class MainActivity : BasePublicActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginWindow = findViewById<Button>(R.id.activity_main_go_login_window)
        val loginTopWindow = findViewById<Button>(R.id.activity_main_go_login_top_window)

        loginWindow.setOnClickListener {
            // translate window to login.
            val intent = Intent(this, PublicMainActivity::class.java)

            // intent.putExtra("price", price)
            // intent.putExtra("discount", discount)
            // startActivityForResult(intent, 1)
            startActivity(intent)
        }

        loginTopWindow.setOnClickListener {
            // translate window to login top.
            val intent = Intent(this, MemberMainActivity::class.java)
            startActivity(intent)
        }
    }
}
