package com.find.android.core.util.recognition

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import com.find.android.FindActivity
import com.find.android.core.util.recognition.broadcast.ActivityRecognitionReceiver
import com.google.android.gms.location.*
import javax.inject.Inject

@SuppressLint("MissingPermission")
class ActivityDetectServiceImpl @Inject constructor(
    private val client: ActivityRecognitionClient
) : ActivityDetectService {

    override fun requestActivityTransitionUpdates(activity: FindActivity) {
        val request = ActivityTransitionRequest(getTransitions())
        client.requestActivityTransitionUpdates(request, getPendingIntent(activity))
            .addOnSuccessListener {}
            .addOnFailureListener { e: Exception -> }
    }

    override fun removeActivityTransitionUpdates(activity: FindActivity) {
        client.removeActivityTransitionUpdates(getPendingIntent(activity))
            .addOnSuccessListener {
                getPendingIntent(activity).cancel()
            }
            .addOnFailureListener { e: Exception -> }
    }


    private fun getPendingIntent(activity: FindActivity): PendingIntent {
        val intent = Intent(activity, ActivityRecognitionReceiver::class.java)
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            PendingIntent.getBroadcast(
                activity,
                REQUEST_CODE_INTENT_ACTIVITY_TRANSITION,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_MUTABLE
            )
        } else {
            PendingIntent.getBroadcast(
                activity,
                REQUEST_CODE_INTENT_ACTIVITY_TRANSITION,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )
        }
    }


    override fun getTransitions(): MutableList<ActivityTransition> {
        val transitions = mutableListOf<ActivityTransition>()
        val transitionTypes = intArrayOf(
            DetectedActivity.IN_VEHICLE,
            DetectedActivity.ON_BICYCLE,
            DetectedActivity.RUNNING,
            DetectedActivity.STILL,
            DetectedActivity.WALKING,
            DetectedActivity.ON_FOOT,
        )

        for (activity in transitionTypes) {
            transitions +=
                ActivityTransition.Builder()
                    .setActivityType(activity)
                    .setActivityTransition(ActivityTransition.ACTIVITY_TRANSITION_ENTER)
                    .build()
            transitions +=
                ActivityTransition.Builder()
                    .setActivityType(activity)
                    .setActivityTransition(ActivityTransition.ACTIVITY_TRANSITION_EXIT)
                    .build()
        }
        return transitions
    }

    companion object {
        const val REQUEST_CODE_INTENT_ACTIVITY_TRANSITION = 1
    }
}