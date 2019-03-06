package com.example.hirasaki.androidexperiment.template

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hirasaki.androidexperiment.R
import com.example.hirasaki.androidexperiment.friends.utils.FriendContract
import com.example.hirasaki.androidexperiment.friends.utils.FriendPresenter
import com.example.hirasaki.androidexperiment.friends.utils.FriendValidator

class TemplateFragment(): Fragment() {
    private var mContext: Context? = null
    private lateinit var presenter: FriendPresenter
    private val validator: FriendValidator = FriendValidator()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // set Context.
        mContext = inflater.getContext()
        presenter = FriendPresenter(mContext!!, this as FriendContract.View)
        return inflater.inflate(R.layout.fragment_friends, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
