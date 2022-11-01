package com.find.android.core.data.local.room.entity

import androidx.room.*
import com.find.android.core.data.repository.DetectedActivityEnum

class ActivityTypeConverter {

    @TypeConverter
    fun fromTypeToString(activityType: DetectedActivityEnum): String = activityType.name

    @TypeConverter
    fun toStringFromType(activityType: String): DetectedActivityEnum = DetectedActivityEnum.valueOf(activityType)

}

@Entity
data class User(
    @PrimaryKey val uid: String,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "surname") var surname: String,
    @ColumnInfo(name = "email") var email: String,
    @field:TypeConverters(ActivityTypeConverter::class)
    @ColumnInfo(name = "activity type") var activityType: DetectedActivityEnum,
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB) var image: ByteArray? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (uid != other.uid) return false
        if (name != other.name) return false
        if (surname != other.surname) return false
        if (email != other.email) return false
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
        result = 31 * result + activityType.hashCode()
        result = 31 * result + (image?.contentHashCode() ?: 0)
        return result
    }

}
