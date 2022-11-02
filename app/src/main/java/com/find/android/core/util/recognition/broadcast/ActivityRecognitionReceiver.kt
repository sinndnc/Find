package com.find.android.core.util.recognition.broadcast

import android.content.*
import android.util.Log
import com.find.android.core.domain.repository.ActivityRecognitionRepository
import com.find.android.core.util.location.LocationService
import com.google.android.gms.location.ActivityTransitionResult
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ActivityRecognitionReceiver : BroadcastReceiver() {

    @Inject
    lateinit var activityRecognitionRepository: ActivityRecognitionRepository

    override fun onReceive(context: Context, intent: Intent) {
        if (ActivityTransitionResult.hasResult(intent)) {
            val result = ActivityTransitionResult.extractResult(intent)!!
            for (event in result.transitionEvents) {
                Log.d("LocationTest", "$event onReceive")
                activityRecognitionRepository.setCurrentActivityType(event)
            }
        }
    }



}
