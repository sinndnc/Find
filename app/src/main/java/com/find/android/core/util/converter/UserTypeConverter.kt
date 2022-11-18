package com.find.android.core.util.converter

import androidx.room.TypeConverter
import com.google.gson.Gson

class UserTypeConverters {
    @TypeConverter
    fun convertUserListToJSONString(userList: List<String>): String =
        Gson().toJson(userList)

    @TypeConverter
    fun convertJSONStringToUserList(jsonString: String): List<String> =
        Gson().fromJson(jsonString, List::class.java) as List<String>
}