package com.example.hirasaki.androidexperiment.friends.friendinput

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.hirasaki.androidexperiment.R
import com.example.hirasaki.androidexperiment.friends.data.FriendModel
import com.example.hirasaki.androidexperiment.friends.utils.FriendPresenter
import com.example.hirasaki.androidexperiment.friends.utils.FriendValidator
// import com.example.hirasaki.androidexperiment.util.DatePickerFragmentDialog
import java.util.*

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

        // date picker
        val dateButton = view.findViewById<Button>(R.id.friend_input_birthday)
        var cal = Calendar.getInstance()
        val birthday_view = view.findViewById<TextView>(R.id.friend_input_birthday_view)

        // tap add button.
        val addButton = view.findViewById<Button>(R.id.friend_input_button)

        /**
         * processing when tap add button.
         */
        addButton.setOnClickListener {
            // get parameters
            val id:Int = 0
            val name = view.findViewById<EditText>(R.id.friend_input_name)
            val sex = view.findViewById<RadioGroup>(R.id.friend_input_sex_group)
            val sex_man = view.findViewById<RadioButton>(R.id.friend_input_sex_man)
            val birthday = view.findViewById<TextView>(R.id.friend_input_birthday_view)
            val profile = view.findViewById<EditText>(R.id.friend_input_profile)
            // val birth: Date = Date(birthday.text.toString())
            val selected_sex = sex.getCheckedRadioButtonId()

            // create model
            val friendModel = FriendModel(
                id,
                name.text.toString(),
                selected_sex.toString().toBoolean(),
                cal.getTime(),
                profile.text.toString()
            )

            // validate
            val validate_result = validator.validate(friendModel)

            // has errors
            if (validate_result.size > 0) {
                Log.d("FriendsInputFragment", "has errors.")

                // show error messages
                for (error in validate_result) {
                    when (error.target) {
                        "name"      -> name.error = error.message
                        "sex"       -> sex_man.error = error.message
                        "birthday"  -> birthday.error = error.message
                        "profile"   -> profile.error = error.message
                    }
                }
                return@setOnClickListener
            }

            // add
            Log.d("FriendsInputFragment", "error is nothing.")

        }

        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int,
                                   dayOfMonth: Int) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                Log.d("FriendsInputFragment", year.toString())
                Log.d("FriendsInputFragment", monthOfYear.toString())
                Log.d("FriendsInputFragment", dayOfMonth.toString())

                birthday_view.text = String.format(Locale.US, "%04d-%02d-%02d",year, monthOfYear+1, dayOfMonth)
            }
        }
        dateButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(activity,
                    dateSetListener,
                    // set DatePickerDialog to point to today's date when it loads up
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
            }
            // val newFragment = DatePickerFragmentDialog()
            // newFragment.show(getFragmentManager(), "datePicker")
        })
    }
}

