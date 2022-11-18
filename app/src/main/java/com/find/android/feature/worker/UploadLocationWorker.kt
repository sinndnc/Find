package com.find.android.feature.worker

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.find.android.core.util.annotation.IoDispatcher
import com.find.android.core.util.location.LocationService
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.RemoteMessage
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltWorker
class UploadLocationWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters,
    private val locationService: LocationService,
    private val firebaseMessaging: FirebaseMessaging,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : Worker(context, workerParams) {

    override fun doWork(): Result {
        Log.d("CloudTest", "Do work")
        val to = inputData.getString("to")!!
        locationService.requestLocationUpdates().onEach { state ->
            state.onLoading {

            }.onSuccess { locationModel ->
                Log.d("CloudTest", "$locationModel Do work")
                firebaseMessaging.send(
                    RemoteMessage.Builder(to)
                        .addData("type", "Location")
                        .addData("requestType", "Receiver")
                        .addData("location", locationModel.toString())
                        .build()
                )
            }.onError {

            }
        }.launchIn(CoroutineScope(ioDispatcher))
        return Result.success()
    }


}