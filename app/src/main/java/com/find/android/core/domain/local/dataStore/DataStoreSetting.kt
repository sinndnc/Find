package com.find.android.core.domain.local.dataStore

import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.Flow


abstract class DataStoreSetting {
    abstract val dataStore: Flow<Preferences>

    //String
    abstract suspend fun writeStringData(key: Preferences.Key<String>, data: String)
    abstract fun readStringData(key: Preferences.Key<String>): Flow<String>

    //Int
    abstract suspend fun writeIntData(key: Preferences.Key<Int>, data: Int)
    abstract fun readIntData(key: Preferences.Key<Int>): Flow<Int?>

    //Boolean
    abstract suspend fun writeBooleanData(key: Preferences.Key<Boolean>, data: Boolean)
    abstract fun readBooleanData(key: Preferences.Key<Boolean>): Flow<Boolean?>


}