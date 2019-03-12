package com.example.hirasaki.androidexperiment.member

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import com.example.hirasaki.androidexperiment.R
import com.example.hirasaki.androidexperiment.bases.activities.BaseLoginActivity
import com.example.hirasaki.androidexperiment.member.friends.data.FriendModel
import com.example.hirasaki.androidexperiment.member.friends.pages.index.FriendsListFragment
import com.example.hirasaki.androidexperiment.member.home.HomeFragment
import com.example.hirasaki.androidexperiment.member.profile.ProfileFragment
import com.idescout.sql.SqlScoutServer
import kotlinx.android.synthetic.main.member_index.*

class MemberMainActivity : BaseLoginActivity() {
    private var loaderResult: Array<FriendModel>? = null
    private var sqlScoutServer: SqlScoutServer? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_home -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.mainFrameLayout, HomeFragment())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_friends -> {
                supportFragmentManager.beginTransaction()
                    .replace(
                        R.id.mainFrameLayout,
                        FriendsListFragment()
                    )
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_profile -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.mainFrameLayout, ProfileFragment())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sqlScoutServer = SqlScoutServer.create(this, packageName)

        setContentView(R.layout.member_index)

        // call loaderManager
        // val loader_bundle = Bundle()
        // loaderManager.initLoader(1, null, this)
        // loaderManager.initLoader(1, null, this)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        // Initial display
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainFrameLayout, HomeFragment())
            .commit()
    }

    override fun onResume() {
        sqlScoutServer!!.resume()
        super.onResume()
    }

    override fun onPause() {
        sqlScoutServer!!.destroy()
        super.onPause()
    }

    override fun onStop() {
        sqlScoutServer!!.destroy()
        super.onStop()
    }

    override fun onDestroy() {
        sqlScoutServer!!.destroy()
        super.onDestroy()
    }
}
