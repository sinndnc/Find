package com.find.android.core.data.remote.storage

import android.util.Log
import com.find.android.core.constant.FirestoreConstants
import com.find.android.core.data.local.room.entity.LocationModel
import com.find.android.core.data.local.room.entity.User
import com.find.android.core.domain.model.UserModel
import com.find.android.core.domain.remote.storage.RemoteStorageService
import com.find.android.core.util.annotation.IoDispatcher
import com.find.android.core.util.event.ResponseState
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.StorageReference
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class RemoteStorageServiceImpl @Inject constructor(
    private val storage: StorageReference,
    private val firebaseAuth: FirebaseAuth,
    private val firestore: FirebaseFirestore,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : RemoteStorageService {

    override fun getUserByUid(uid: String): Flow<ResponseState<UserModel>> = flow {
        emit(ResponseState.Loading)
        val response = firestore.collection(FirestoreConstants.USER_COLLECTION).document(uid).get().await()
        if (response.exists()) {
            val user = response.toObject(UserModel::class.java)!!.apply {
                image = getUserImage(uid)
            }
            emit(ResponseState.Success(user))
        } else {
            emit(ResponseState.Error(Throwable("Document is not exists")))
        }
    }

    override suspend fun getUserImage(uid: String): ByteArray {
        val response = storage.child("sindnnc.jpg").getBytes(1024 * 1024).await()
        Log.d("BitmapTest", response.decodeToString())
        return if (response.isNotEmpty()) {
            response
        } else {
            byteArrayOf()
        }
    }

    override fun getUserLocation(): LocationModel =
        runBlocking(ioDispatcher) {
            firestore.collection(FirestoreConstants.USER_COLLECTION).document(firebaseAuth.uid!!).get().await()
                .toObject(User::class.java)!!.location
        }


    override fun insertUser(user: UserModel) {

    }


}