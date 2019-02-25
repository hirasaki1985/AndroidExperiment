package com.example.hirasaki.androidexperiment

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.example.hirasaki.androidexperiment.friends.data.FriendModel
import com.example.hirasaki.androidexperiment.friends.index.FriendsListFragment
// import com.example.hirasaki.androidexperiment.friends.loader.FriendsLoader
import com.example.hirasaki.androidexperiment.home.HomeFragment
import com.example.hirasaki.androidexperiment.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

// class MainActivity : AppCompatActivity(), LoaderManager.LoaderCallbacks<FriendModel> {
class MainActivity : AppCompatActivity() {
    private var loaderResult: Array<FriendModel>? = null

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
        setContentView(R.layout.activity_main)

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

    /*
    private val callback: LoaderManager.LoaderCallbacks<String> = object : LoaderManager.LoaderCallbacks<String> {
        override fun onCreateLoader(id: Int, args: Bundle?) : Loader<String> {
            val param = args?.getString("TEST") // 今回は使わない URLをUIから指定とかしたいときは使う
            return FriendsLoader(this@MainActivity) // Loaderがv4なのでAsyncTaskLoaderもv4
        }

        override fun onLoadFinished(loader: Loader<String>?, data: String?) {
            supportLoaderManager.destroyLoader(loader?.id ?: 1)
            loaderResult = data.toString() // dataにloadInBackgroundのreturn値が入っている
            textView.text = loaderResult
        }

        override fun onLoaderReset(loader: Loader<String>?) {
            // 今回は何もしない
        }
    }
    */
}
