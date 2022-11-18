package com.find.android.core.util.message

import android.util.Log
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.find.android.core.data.local.room.dao.UserDao
import com.find.android.core.util.message.enum.CloudMessageEnum
import com.find.android.feature.worker.UploadLocationWorker
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Exception
import javax.inject.Inject

@AndroidEntryPoint
class CloudMessageService : FirebaseMessagingService() {

    @Inject
    lateinit var database: UserDao

    @Inject
    lateinit var firebaseAuth: FirebaseAuth

    @Inject
    lateinit var firebaseMessaging: FirebaseMessaging

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        if (message.data.isNotEmpty()) {
            if (message.data["type"] == CloudMessageEnum.Location.name) {
                if (message.data["requestType"] == "Receiver") {
                    Log.d("CloudTest", "${message.data}")
                    val locationWorker = OneTimeWorkRequestBuilder<UploadLocationWorker>()
                    val data = Data.Builder()
                    data.putString(
                        "to",
                        "cnHgx7C2RbuEm9LqfZtLGI:APA91bEPFi8nTkxGYjWilB3VaiRqK8aC6i06tOHFRqtpW63UnzackuuP2tMPr9KxgaaaYYF-JjHTPXFjWxHEyCLA2GqoQ93euSPbLvnzKCqwQoXrVwaWxCeXImcqUeN4GSnHR8WZjRHm"
                    )
                    locationWorker.setInputData(data.build())
                    WorkManager.getInstance(applicationContext).enqueue(locationWorker.build())
                }
            }
        }
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        database.setUserToken(firebaseAuth.uid!!, token)
    }

    override fun onMessageSent(msgId: String) {
        super.onMessageSent(msgId)
        Log.d("CloudTest", msgId)
    }

    override fun onSendError(msgId: String, exception: Exception) {
        super.onSendError(msgId, exception)
        Log.d("CloudTest", "messageId: $msgId,exception: $exception")
    }
}