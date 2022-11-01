package com.find.android.core.di.module

import android.content.Context
import androidx.room.Room
import com.find.android.core.data.local.room.dao.UserDao
import com.find.android.core.data.local.room.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext applicationContext: Context): AppDatabase = Room.databaseBuilder(
        applicationContext, AppDatabase::class.java, "find-Database"
    ).build()

    @Provides
    @Singleton
    fun provideUserDaoDatabase(database: AppDatabase): UserDao = database.userDao()


}