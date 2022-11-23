package com.find.android.core.data.repository


import android.app.Activity
import com.find.android.FindActivity
import com.find.android.core.domain.repository.ActivityRecognitionRepository
import com.find.android.core.domain.repository.StorageRepository
import com.find.android.core.util.recognition.ActivityRecognitionService
import com.find.android.feature.util.extension.toActivityEnum
import com.google.android.gms.location.ActivityTransitionEvent
import javax.inject.Inject

class ActivityRecognitionRepositoryImpl @Inject constructor(
    private val storageRepository: StorageRepository,
    private val activityRecognitionService: ActivityRecognitionService,
) : ActivityRecognitionRepository {

    override fun setCurrentActivityType(activity: ActivityTransitionEvent) {
        val currentActivityType = activity.activityType.toActivityEnum()
        storageRepository.setUserActivityType(currentActivityType)
    }

    override fun startActivityRecognitionService(activity: Activity) =
        activityRecognitionService.requestActivityTransitionUpdates(activity as FindActivity)

    override fun stopActivityRecognitionService(activity: Activity) =
        activityRecognitionService.removeActivityTransitionUpdates(activity as FindActivity)

}