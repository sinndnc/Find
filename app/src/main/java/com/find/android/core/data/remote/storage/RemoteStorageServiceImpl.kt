package com.find.android.core.data.remote.storage

import com.find.android.core.constant.FirestoreConstants
import com.find.android.core.data.local.room.entity.LocationModel
import com.find.android.core.domain.model.UserModel
import com.find.android.core.domain.remote.storage.RemoteStorageService
import com.find.android.core.util.annotation.IoDispatcher
import com.find.android.feature.util.extension.toLocationModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.StorageReference
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class RemoteStorageServiceImpl @Inject constructor(
    private val storage: StorageReference,
    private val firebaseAuth: FirebaseAuth,
    private val firestore: FirebaseFirestore,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : RemoteStorageService {

    override fun getUserByUid(uid: String): UserModel =
        runBlocking(ioDispatcher) {
            val response = firestore.collection(FirestoreConstants.USER_COLLECTION).document(uid).get().await()
            if (response.exists()) response.toObject(UserModel::class.java)!!.apply { image = getUserImage(uid) } else UserModel()
        }

    override fun getUserImage(uid: String): ByteArray =
        runBlocking(ioDispatcher) {
            val response = storage.child("sindnnc.jpg").getBytes(1024 * 1024).await()
            if (response.isNotEmpty()) response else byteArrayOf()
        }

    override fun getUserLocation(): LocationModel =
        runBlocking(ioDispatcher) {
            val doc = firestore.collection(FirestoreConstants.USER_COLLECTION).document(firebaseAuth.uid!!).get().await()
            val geoPoint = doc.getGeoPoint("location")
            geoPoint!!.toLocationModel()
        }


    override fun insertUser(user: UserModel) {

    }


}