package com.example.hirasaki.androidexperiment.friends.data

import com.example.hirasaki.androidexperiment.bases.BaseModel
import java.util.*

class FriendModel(_id: Int = 0, _name: String = "", _sex: Boolean = true, _profile: String = "", _birthday: Date? = null): BaseModel() {
    var id: Int = _id
    var name: String = _name
    var sex: Boolean = _sex
    var profile: String = _profile
    var birthday: Date? = _birthday

    /*
    public fun set(_id: Int = 0, _name: String = "", _sex: Boolean = true, _profile: String = "", _birthday: Date? = null) {
        id = _id
        name = _name
        sex = _sex
        profile = _profile
        birthday = _birthday
    }
    */
}
