package com.example.hirasaki.androidexperiment.friends.friendinput

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.RadioButton
import com.example.hirasaki.androidexperiment.R
import com.example.hirasaki.androidexperiment.friends.utils.FriendPresenter
import com.example.hirasaki.androidexperiment.friends.utils.FriendValidator

class FriendsInputFragment: Fragment() {
    private var mContext: Context? = null
    private val presenter: FriendPresenter = FriendPresenter()
    private val validator: FriendValidator = FriendValidator()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // set Context.
        mContext = inflater.getContext()
        return inflater.inflate(R.layout.friends_friendinput, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // tap add button.
        val addButton = view.findViewById<Button>(R.id.friend_input_button)

        /**
         * processing when tap add button.
         */
        addButton.setOnClickListener {
            var isValid = true

            val id = 0
            val name = view.findViewById<EditText>(R.id.friend_input_name)
            val sex = view.findViewById<RadioButton>(R.id.friend_input_sex_group)
            val birthday = view.findViewById<DatePicker>(R.id.friend_input_birthday)
            val profile = view.findViewById<EditText>(R.id.friend_input_profile)

            /*
            val friendModel = FriendModel(
                id,
                name.text.toString(),
                sex.getTag().toString().toBoolean(),
                ,
                profile.text.toString()
            )
            */
        }
    }
}
