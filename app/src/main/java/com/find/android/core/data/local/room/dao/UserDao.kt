package com.find.android.core.data.local.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.find.android.core.data.local.room.entity.User
import com.find.android.core.data.repository.DetectedActivityEnum

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAllUser(): List<User>

    @Query("SELECT * FROM user WHERE uid LIKE :uid")
    fun getUserByUid(uid: String): User

    @Insert
    fun insertUser(vararg users: User)

    @Query("SELECT `activity type` FROM user WHERE uid LIKE :uid")
    fun getUserActivityType(uid: String) : DetectedActivityEnum

    @Query("UPDATE User SET `activity type`= :activityType WHERE uid= :uid")
    fun setUserActivityType(uid: String,activityType: String)

    @Delete
    fun deleteUser(user: User)
}