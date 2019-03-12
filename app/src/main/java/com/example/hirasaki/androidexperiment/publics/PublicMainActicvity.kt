package com.example.hirasaki.androidexperiment.publics

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.example.hirasaki.androidexperiment.R
import com.example.hirasaki.androidexperiment.bases.activities.BasePublicActivity

class PublicMainActivity: BasePublicActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.public_index)
    }
}
