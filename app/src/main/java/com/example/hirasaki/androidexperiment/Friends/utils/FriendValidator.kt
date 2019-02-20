package com.example.hirasaki.androidexperiment.friends.utils

import android.util.Log
import com.example.hirasaki.androidexperiment.bases.BaseModel
import com.example.hirasaki.androidexperiment.bases.BaseValidator
import com.example.hirasaki.androidexperiment.friends.data.FriendModel
import com.example.hirasaki.androidexperiment.util.ErrorMessage

class FriendValidator(): BaseValidator() {
    fun validate(model: FriendModel):Array<ErrorMessage> {
        Log.d("FriendValidator", model.toString())

        var result = mutableListOf<ErrorMessage>()
        var index: Int = 0

        if (model.name.isEmpty()) {
            // result.set(index++, ErrorMessage("name", "名前が入力されていません"))
            result.add(ErrorMessage("name", "名前が入力されていません"))
        }

        Log.d("FriendValidator", "size = " + result.size.toString())
        return result.toTypedArray()
    }
}
