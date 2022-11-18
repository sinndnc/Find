package com.find.android.core.data.local.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.find.android.core.data.local.room.dao.UserDao
import com.find.android.core.data.local.room.entity.LocalUserModel

@Database(entities = [LocalUserModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}