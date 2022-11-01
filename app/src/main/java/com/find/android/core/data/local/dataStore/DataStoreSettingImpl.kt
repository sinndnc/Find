package com.find.android.core.data.local.dataStore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.find.android.core.constant.AppConstant
import com.find.android.core.domain.local.dataStore.DataStoreSetting
import com.find.android.core.util.resources.baseReadFlowResource
import com.find.android.core.util.resources.baseWriteFlowResource
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = AppConstant.LOCAL_STORAGE_NAME)

class DataStoreSettingImpl @Inject constructor(@ApplicationContext private val context: Context) : DataStoreSetting() {

    override val dataStore: Flow<Preferences> get() = context.dataStore.data

    override suspend fun writeStringData(key: Preferences.Key<String>, data: String) =
        withContext(Dispatchers.IO) { context.baseWriteFlowResource(key, data) }

    override fun readStringData(key: Preferences.Key<String>): Flow<String> =
        dataStore.baseReadFlowResource(key)

    override suspend fun writeIntData(key: Preferences.Key<Int>, data: Int) =
        withContext(Dispatchers.IO) { context.baseWriteFlowResource(key, data) }

    override fun readIntData(key: Preferences.Key<Int>): Flow<Int?> =
        dataStore.baseReadFlowResource(key)

    override suspend fun writeBooleanData(key: Preferences.Key<Boolean>, data: Boolean) =
        withContext(Dispatchers.IO) { context.baseWriteFlowResource(key, data) }

    override fun readBooleanData(key: Preferences.Key<Boolean>): Flow<Boolean?> =
        dataStore.baseReadFlowResource(key)

}