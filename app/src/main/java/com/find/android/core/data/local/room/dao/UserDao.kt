package com.find.android.core.data.local.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.find.android.core.data.local.room.entity.LocationModel
import com.find.android.core.data.local.room.entity.User
import com.find.android.core.util.recognition.enums.DetectedActivityEnum

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAllUser(): List<User>

    @Insert
    fun insertUser(vararg users: User)

    @Query("SELECT * FROM user WHERE uid LIKE :uid")
    fun getUserByUid(uid: String): User

    @Query("UPDATE User SET image = :image WHERE uid = :uid")
    fun updateUserImage(uid: String, image: ByteArray)

    @Query("SELECT `activity type` FROM user WHERE uid LIKE :uid")
    fun getUserActivityType(uid: String): DetectedActivityEnum

    @Query("UPDATE User SET `activity type`= :activityType WHERE uid= :uid")
    fun setUserActivityType(uid: String, activityType: String)

    @Query("SELECT longitude,latitude FROM user WHERE uid LIKE :uid")
    fun getUserLocation(uid: String): LocationModel

    @Delete
    fun deleteUser(user: User)
}