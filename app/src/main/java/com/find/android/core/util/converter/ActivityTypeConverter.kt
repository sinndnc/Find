package com.find.android.core.util.converter

import androidx.room.TypeConverter
import com.find.android.core.util.recognition.enums.DetectedActivityEnum


class ActivityTypeConverter {
    @TypeConverter
    fun fromTypeToString(activityType: DetectedActivityEnum): String = activityType.name

    @TypeConverter
    fun toStringFromType(activityType: String): DetectedActivityEnum = DetectedActivityEnum.valueOf(activityType)
}