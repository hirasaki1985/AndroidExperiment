package com.example.hirasaki.androidexperiment.pages.member.profile.reference

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hirasaki.androidexperiment.R

class ProfileReferenceIndexFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return  inflater.inflate(R.layout.member_profile_reference, container, false)
    }
}
