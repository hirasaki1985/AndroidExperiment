package com.example.hirasaki.androidexperiment.member.friends.pages.detail

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hirasaki.androidexperiment.R
import android.util.Log
// import android.widget.Toast
// import java.util.*
// import android.widget.Toast
import android.widget.TextView

class FriendsDetailFragment : Fragment() {
    private var mContext: Context? = null
    private var id: Int? = null

    /*
    companion object {
        fun createInstance(maker:String, brand:String): FriendsDetailFragment {
            val carDetailFragment = FriendsDetailFragment()
            val args = Bundle()
            args.putString('id', maker)
            args.putString(KEY_BRAND, brand)
            carDetailFragment.arguments = args
            return carDetailFragment
        }
    }
    */

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // set Context.
        mContext = inflater.getContext()

        // get arguments
        val args = getArguments()
        if (args != null) {
            id = args.getInt("id")
        }

        return inflater.inflate(R.layout.friends_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("FriendsDetailFragment", id.toString())

        val detail_id = view.findViewById<TextView>(R.id.friends_detail_id)
        detail_id.text = id.toString()
    }
}
