package com.find.android.core.di.module

import android.app.Application
import android.content.Context
import android.location.LocationManager
import android.net.ConnectivityManager
import com.find.android.core.util.annotation.GoogleApi
import com.google.android.gms.common.GoogleApiAvailability
import com.google.android.gms.location.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object GoogleModule {

    @Provides
    @Singleton
    fun provideFusedLocationProviderClient(application: Application): FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(application)

    @Provides
    @Singleton
    fun provideActivityRecognitionClient(@ApplicationContext context: Context): ActivityRecognitionClient =
        ActivityRecognition.getClient(context)

    @Provides
    @Singleton
    fun provideLocationSettingClient(@ApplicationContext context: Context): SettingsClient =
        LocationServices.getSettingsClient(context)

    @Provides
    @Singleton
    fun provideGoogleApiAvailability(): GoogleApiAvailability = GoogleApiAvailability.getInstance()

    @Provides
    @Singleton
    @GoogleApi
    fun provideGoogleApiIsAvailable(
        googleApiAvailability: GoogleApiAvailability,
        @ApplicationContext context: Context
    ): Int = googleApiAvailability.isGooglePlayServicesAvailable(context)

    @Provides
    @Singleton
    fun provideConnectivityManager(@ApplicationContext context: Context): ConnectivityManager =
        context.getSystemService(ConnectivityManager::class.java)


    @Provides
    @Singleton
    fun provideNetworkManager(@ApplicationContext context: Context): LocationManager =
        context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
}