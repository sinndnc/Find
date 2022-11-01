package com.find.android.core.util.location

import android.annotation.SuppressLint
import android.app.Service
import android.content.*
import android.os.IBinder
import android.util.Log
import com.find.android.core.data.repository.DetectedActivityEnum
import com.find.android.core.domain.repository.ActivityRecognitionRepository
import com.find.android.core.domain.usecase.location.map.LocationHelper
import com.find.android.core.util.notification.component.NotificationComponent
import com.google.android.gms.location.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@AndroidEntryPoint
@SuppressLint("MissingPermission")
class LocationService : Service() {

    @Inject
    lateinit var locationHelper: LocationHelper

    @Inject
    lateinit var notificationComponent: NotificationComponent

    @Inject
    lateinit var activityRecognitionRepository: ActivityRecognitionRepository


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("LocationTest", "onStartCommand")
        startForeground(1, notificationComponent.buildServiceNotification(this.applicationContext))
        when (activityRecognitionRepository.currentActivity?.value) {
            DetectedActivityEnum.STILL -> locationHelper.getCurrentLocation()
            else -> locationHelper.requestLocationUpdates()
        }
        return START_STICKY
    }



    override fun onCreate() {
        super.onCreate()
        Log.d("LocationTest", "onCreate")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LocationTest", "onDestroy")
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}