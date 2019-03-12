package com.example.hirasaki.androidexperiment.member.friends.data

import com.example.hirasaki.androidexperiment.bases.BaseModel
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*

class FriendModel(_id: Int = 0, _name: String = "", _sex: Boolean = true, _birthday: Date? = null, _profile: String = ""): BaseModel() {
    private val df = SimpleDateFormat("yyyy-MM-dd")

    var id: Int = _id
    var name: String = _name
    var sex: Boolean = _sex
    var profile: String = _profile
    var birthday: Date? = _birthday

    init {

    }

    override fun convert(json: JSONObject) {
        id = json.get("id").toString().toInt()
        name = json.get("name").toString()
        birthday = Date(json.get("birthday").toString())
        profile = json.get("profile").toString()
    }

    override fun toObject(): JSONObject {
        val obj = JSONObject()
        obj.put("id", id)
        obj.put("name", name)
        if (sex) {
            obj.put("sex", 1)
        } else {
            obj.put("sex", 0)
        }
        obj.put("birthday", df.format(birthday))
        obj.put("profile", profile)
        return obj
    }
}
