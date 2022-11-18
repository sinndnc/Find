package com.find.android

import com.find.android.Dependencies.Compose.compose_version


/**
 * For all packages you can click this link to see the source code:
 * https://developer.android.com/reference/packages
 */
object Dependencies {
    private const val hilt_version = "2.44"

    object Plugin {
        const val jvm = "jvm"
        const val kapt = "kapt"
        const val library = "com.android.library"
        const val hilt = "dagger.hilt.android.plugin"
        const val application = "com.android.application"
        const val kotlin = "org.jetbrains.kotlin.android"
        const val serialization = "plugin.serialization"
        const val googleService = "com.google.gms.google-services"

    }

    object Gradle {
        const val android = "com.android.tools.build:gradle:7.2.0"
        const val googleService = "com.google.gms:google-services:4.3.13"
        const val hilt = "com.google.dagger:hilt-android-gradle-plugin:$hilt_version"
    }

    object Androidx {
        const val activity = "androidx.activity:activity-ktx:1.6.0"
        const val core = "androidx.core:core-ktx:1.8.0"
    }

    object Firebase {
        private const val version = "30.4.1"
        const val auth = "com.google.firebase:firebase-auth-ktx"
        const val boom = "com.google.firebase:firebase-bom:$version"
        const val storage = "com.google.firebase:firebase-storage-ktx"
        const val analytics = "com.google.firebase:firebase-analytics-ktx"
        const val firestore = "com.google.firebase:firebase-firestore-ktx"
        const val bootAware = "com.google.firebase:firebase-messaging-directboot:20.2.0"
        const val messaging = "com.google.firebase:firebase-messaging-ktx"
    }

    object WorkManager{
        private const val version = "2.7.1"
        const val runtime = "androidx.work:work-runtime-ktx:$version"
    }

    object GoogleService {
        private const val version = "18.1.0"
        const val maps = "com.google.android.gms:play-services-maps:$version"
        const val location = "com.google.android.gms:play-services-location:20.0.0"
    }

    object Hilt {
        const val workManager = "androidx.hilt:hilt-work:1.0.0"
        const val hiltCompiler = "androidx.hilt:hilt-compiler:1.0.0"
        const val hilt = "com.google.dagger:hilt-android:$hilt_version"
        const val hiltKapt = "com.google.dagger:hilt-android-compiler:$hilt_version"
    }

    object Coroutines {
        private const val version = "1.3.6"
        const val services = "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:$version"
    }

    object Preferences {
        private const val version = "1.0.0"
        const val datastore = "androidx.datastore:datastore-preferences:$version"
    }

    object Serialization {
        private const val version = "1.4.0"
        const val runtime = "org.jetbrains.kotlinx:kotlinx-serialization-json:$version"
        const val gson = "com.google.code.gson:gson:2.9.0"
    }

    object Compose {
        const val compose_version = "1.2.1"
        const val ui = "androidx.compose.ui:ui:$compose_version"
        const val activity = "androidx.activity:activity-compose:1.5.1"
        const val material = "androidx.compose.material:material:$compose_version"
        const val maps = "com.google.maps.android:maps-compose:2.5.3"
    }

    object Lifecycle {
        private const val version = "2.5.1"
        const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
        const val service = "androidx.lifecycle:lifecycle-service:$version"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
    }

    object Navigation {
        private const val version = "1.0.0"
        const val compose = "androidx.navigation:navigation-compose:2.5.2"
        const val hilt = "androidx.hilt:hilt-navigation-compose:$version"

    }

    object Room{
        private const val version = "2.4.3"
        const val runtime = "androidx.room:room-runtime:$version"
        const val compiler = "androidx.room:room-compiler:$version"
    }

    object Config {
        const val applicationName = "Find"
        const val applicationId = "com.find.android"
        const val targetSdk = 32
        const val minSdk = 29
        const val versionCode = 1
        const val versionName = "1.0"
    }

    //Test
    object Test {
        const val junit = "junit:junit:4.13.2"
    }

    object AndroidTest {
        const val junit = "androidx.test.ext:junit:1.1.3"
        const val espresso = "androidx.test.espresso:espresso-core:3.4.0"
        const val uiJunit = "androidx.compose.ui:ui-test-junit4:$compose_version"
    }

    object DebugTest {
        const val uiTooling = "androidx.compose.ui:ui-tooling:$compose_version"
        const val uiManifest = "androidx.compose.ui:ui-test-manifest:$compose_version"
    }
}