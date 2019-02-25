package com.example.hirasaki.androidexperiment.profile

import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hirasaki.androidexperiment.friends.index.FriendsListFragment
import com.example.hirasaki.androidexperiment.profile.profile.ProfileProfileIndexFragment
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v4.app.FragmentManager
import com.example.hirasaki.androidexperiment.R
import com.example.hirasaki.androidexperiment.profile.feed.ProfileFeedIndexFragment
import com.example.hirasaki.androidexperiment.profile.reference.ProfileReferenceIndexFragment


class ProfileFragment : Fragment() {
    private lateinit var myView: View

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val fragmentManager = getFragmentManager()

        if (fragmentManager != null) {
            when (item.itemId) {
                R.id.profile_nav_profile -> {
                    fragmentManager.beginTransaction()
                        .replace(R.id.profileMainFrameLayout, ProfileProfileIndexFragment())
                        .commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.profile_nav_reference -> {
                    fragmentManager.beginTransaction()
                        .replace(R.id.profileMainFrameLayout, ProfileReferenceIndexFragment())
                        .commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.profile_nav_feed -> {
                    fragmentManager.beginTransaction()
                        .replace(R.id.profileMainFrameLayout, ProfileFeedIndexFragment())
                        .commit()
                    return@OnNavigationItemSelectedListener true
                }
            }
        }
        false
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return  inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myView = view

        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.profile_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val fragmentManager = getFragmentManager()

        // Initial display
        if (fragmentManager != null) {
            fragmentManager.beginTransaction()
                .replace(R.id.profileMainFrameLayout, ProfileProfileIndexFragment())
                .commit()
        }
    }
}
