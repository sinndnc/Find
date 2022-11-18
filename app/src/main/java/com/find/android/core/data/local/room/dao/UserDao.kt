package com.find.android.core.data.local.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.find.android.core.data.local.room.entity.LocalUserModel
import com.find.android.core.domain.model.LocationModel
import com.find.android.core.util.recognition.enums.DetectedActivityEnum

@Dao
interface UserDao {

    @Query("SELECT * FROM LocalUserModel")
    fun getAllUser(): List<LocalUserModel>

    @Insert
    fun insertUser(vararg localUserModels: LocalUserModel)

    @Query("SELECT * FROM LocalUserModel WHERE uid LIKE :uid")
    fun getUserByUid(uid: String): LocalUserModel

    @Query("SELECT friends FROM LocalUserModel WHERE uid LIKE :uid ")
    fun getUserFriendsList(uid: String) : List<String>

    @Query("UPDATE LocalUserModel SET image = :image WHERE uid = :uid")
    fun updateUserImage(uid: String, image: ByteArray)

    @Query("SELECT activityType FROM LocalUserModel WHERE uid LIKE :uid")
    fun getUserActivityType(uid: String): DetectedActivityEnum

    @Query("UPDATE LocalUserModel SET activityType= :activityType WHERE uid= :uid")
    fun setUserActivityType(uid: String, activityType: String)

    @Query("SELECT longitude,latitude FROM LocalUserModel WHERE uid LIKE :uid")
    fun getUserLocation(uid: String): LocationModel

    @Query("UPDATE LocalUserModel SET latitude = :latitude, longitude = :longitude WHERE uid = :uid")
    fun setUserLocation(uid: String, latitude: Double, longitude: Double)

    @Query("UPDATE LocalUserModel SET token = :token WHERE uid = :uid")
    fun setUserToken(uid: String, token: String)

    @Delete
    fun deleteUser(localUserModel: LocalUserModel)
}