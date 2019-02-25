package com.example.hirasaki.androidexperiment.profile.data

import android.util.Log
import com.example.hirasaki.androidexperiment.bases.BaseModel
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*

class ProfileModel(_id: Int = 0, _name: String = "", _sex: Boolean = true, _birthday: Date? = null, _profile: String = "", _icon: String = ""): BaseModel() {
    private val df = SimpleDateFormat("yyyy-MM-dd")
    var id = _id
    var name = _name
    var sex = _sex
    var birthday = _birthday
    var profile = _profile
    var icon = _icon

    override fun convert(json: JSONObject) {
        Log.d("ProfileModel convert()", json.toString())
        id = json.get("id").toString().toInt()
        name = json.get("name").toString()
        try {
            birthday = Date(json.get("birthday").toString())
        } catch (e: IllegalArgumentException) {
            Log.e("birthday", e.toString())
            birthday = null
        }
        profile = json.get("profile").toString()
        icon = json.get("icon").toString()
    }

    override fun toObject(): JSONObject {
        var obj = JSONObject()
        obj.put("id", id)
        obj.put("name", name)
        if (sex) {
            obj.put("sex", 1)
        } else {
            obj.put("sex", 0)
        }
        obj.put("birthday", df.format(birthday))
        obj.put("profile", profile)
        obj.put("icon", icon)

        return obj
    }
}
