package com.example.hirasaki.androidexperiment.member.profile

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hirasaki.androidexperiment.member.profile.profile.ProfileProfileIndexFragment
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.example.hirasaki.androidexperiment.R
import com.example.hirasaki.androidexperiment.member.profile.data.ProfileModel
import com.example.hirasaki.androidexperiment.member.profile.feed.ProfileFeedIndexFragment
import com.example.hirasaki.androidexperiment.member.profile.reference.ProfileReferenceIndexFragment
import com.example.hirasaki.androidexperiment.member.profile.utils.ProfilePresenter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.json.JSONObject


class ProfileFragment : Fragment() {
    private var presenter: ProfilePresenter = ProfilePresenter()
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

        onGetProfile()
    }

    fun onGetProfile() = GlobalScope.launch(Dispatchers.Main) {
        Log.d("ProfileFragment onGetProfile()", "start")
        async(Dispatchers.Default) {
            val params = JSONObject()
            presenter.getProfile(params)
        }.await().let {
            reload(it)
        }
    }

    fun reload(model: ProfileModel) {
        Log.d("ProfileFragment reload()", model.toString())
        val tableId = myView.findViewById<TextView>(R.id.profile_table_id)
        val tableName = myView.findViewById<TextView>(R.id.profile_table_name)
        val imageView = myView.findViewById<ImageView>(R.id.profile_user_image)

        // update view
        val image = presenter.getProfileImage(model)
        if (image != null) {
            Log.d("image", "not null.")
            image.into(imageView)
        }
        tableId.text = model.id.toString()
        tableName.text = model.name
    }
}
