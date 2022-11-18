package com.find.android.core.data.local.room.entity

import androidx.room.*
import com.find.android.core.domain.model.LocationModel
import com.find.android.core.util.converter.ActivityTypeConverter
import com.find.android.core.util.converter.UserTypeConverters
import com.find.android.core.util.recognition.enums.DetectedActivityEnum

@Entity
data class LocalUserModel(
    @PrimaryKey val uid: String,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "surname") var surname: String,
    @ColumnInfo(name = "email") var email: String,
    @ColumnInfo(name = "token") var token: String,
    @Embedded var location: LocationModel,
    @field:TypeConverters(UserTypeConverters::class)
    @ColumnInfo(name = "friends") var friends: List<String>,
    @field:TypeConverters(ActivityTypeConverter::class)
    @ColumnInfo(name = "activityType") var activityType: DetectedActivityEnum,
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB) var image: ByteArray? = null,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LocalUserModel

        if (uid != other.uid) return false
        if (name != other.name) return false
        if (surname != other.surname) return false
        if (email != other.email) return false
        if (token != other.token) return false
        if (friends != other.friends) return false
        if (location != other.location) return false
        if (activityType != other.activityType) return false
        if (image != null) {
            if (other.image == null) return false
            if (!image.contentEquals(other.image)) return false
        } else if (other.image != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = uid.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + surname.hashCode()
        result = 31 * result + email.hashCode()
        result = 31 * result + token.hashCode()
        result = 31 * result + friends.hashCode()
        result = 31 * result + location.hashCode()
        result = 31 * result + activityType.hashCode()
        result = 31 * result + (image?.contentHashCode() ?: 0)
        return result
    }
}
