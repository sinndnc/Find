package com.find.android.core.domain.model

import com.find.android.core.util.recognition.enums.DetectedActivityEnum
import com.google.firebase.firestore.GeoPoint

data class RemoteUserModel(
    val uid: String = "",
    var name: String = "",
    var email: String = "",
    var surname: String = "",
    var token: String = "",
    var location: GeoPoint = GeoPoint(0.0, 0.0),
    var activityType: DetectedActivityEnum = DetectedActivityEnum.UNKNOWN,
    var friends: List<String> = listOf(""),
    var image: ByteArray? = null,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RemoteUserModel

        if (uid != other.uid) return false
        if (name != other.name) return false
        if (email != other.email) return false
        if (surname != other.surname) return false
        if (location != other.location) return false
        if (activityType != other.activityType) return false
        if (friends != other.friends) return false
        if (!image.contentEquals(other.image)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = uid.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + email.hashCode()
        result = 31 * result + surname.hashCode()
        result = 31 * result + location.hashCode()
        result = 31 * result + activityType.hashCode()
        result = 31 * result + friends.hashCode()
        result = 31 * result + image.contentHashCode()
        return result
    }

}