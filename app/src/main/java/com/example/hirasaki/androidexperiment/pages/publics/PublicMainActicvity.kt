package com.example.hirasaki.androidexperiment.pages.publics

import android.os.Bundle
import com.example.hirasaki.androidexperiment.R
import com.example.hirasaki.androidexperiment.bases.activities.BasePublicActivity

class PublicMainActivity: BasePublicActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.public_index)
    }
}
