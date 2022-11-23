package com.find.android.core.data.remote.storage

import android.util.Log
import com.find.android.core.constant.FirestoreConstants
import com.find.android.core.domain.model.LocationModel
import com.find.android.core.domain.model.RemoteUserModel
import com.find.android.core.domain.remote.storage.RemoteStorageService
import com.find.android.core.util.annotation.IoDispatcher
import com.find.android.core.util.event.ResponseState
import com.find.android.core.util.recognition.enums.DetectedActivityEnum
import com.find.android.feature.util.extension.toGeoPoint
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.StorageReference
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class RemoteStorageServiceImpl @Inject constructor(
    private val storage: StorageReference,
    private val firebaseAuth: FirebaseAuth,
    private val firestore: FirebaseFirestore,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : RemoteStorageService {

    override fun getCurrentUser(): Flow<ResponseState<RemoteUserModel>> = flow {
        emit(ResponseState.Loading)
        val response = firestore.collection(FirestoreConstants.USER_COLLECTION).document(firebaseAuth.uid!!).get().await()
        val user = response.toObject(RemoteUserModel::class.java)!!.apply { image = getUserImage(uid) }
        if (response.exists()) emit(ResponseState.Success(user))
    }.catch { exception ->
        emit(ResponseState.Error(exception))
    }.flowOn(ioDispatcher)

    override fun getUserByUid(uid: String): RemoteUserModel = runBlocking(ioDispatcher) {
        val response = firestore.collection(FirestoreConstants.USER_COLLECTION).document(uid).get().await()
        response.toObject(RemoteUserModel::class.java)!!
    }

    override fun getUserImage(uid: String): ByteArray = runBlocking(ioDispatcher) {
        val response = storage.child("sindnnc.jpg").getBytes(1024 * 1024).await()
        if (response.isNotEmpty()) response else byteArrayOf()
    }

    override fun setUserLocation(locationModel: LocationModel) {
        runBlocking(ioDispatcher) {
            val userRef = firestore.collection(FirestoreConstants.USER_COLLECTION).document(firebaseAuth.uid!!)
            userRef.update("location", locationModel.toGeoPoint())
        }
    }

    override fun setUserActivityType(activityType: DetectedActivityEnum) {
        runBlocking(ioDispatcher) {
            val userRef = firestore.collection(FirestoreConstants.USER_COLLECTION).document(firebaseAuth.uid!!)
            userRef.update("activityType", activityType.name)
        }
    }

    override fun getUserFriendList(friendList: List<String>): List<RemoteUserModel> = runBlocking(ioDispatcher) {
        val friends = mutableListOf<RemoteUserModel>()
        for (friend in friendList) {
            friends.add(getUserByUid(friend))
        }
        Log.d("UserTest", "getUserFriendList: $friends")
        friends
    }

    //todo()
    override fun insertUser(user: RemoteUserModel) {

    }


}