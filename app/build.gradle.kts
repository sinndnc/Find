import com.find.android.Dependencies

plugins {
    id(com.find.android.Dependencies.Plugin.hilt)
    id(com.find.android.Dependencies.Plugin.kotlin)
    kotlin(com.find.android.Dependencies.Plugin.kapt)
    id(com.find.android.Dependencies.Plugin.application)
    id(com.find.android.Dependencies.Plugin.googleService)
}

android {
    compileSdk = Dependencies.Config.targetSdk

    defaultConfig {
        applicationId = Dependencies.Config.applicationId
        minSdk = Dependencies.Config.minSdk
        targetSdk = Dependencies.Config.targetSdk
        versionCode = Dependencies.Config.versionCode
        versionName = Dependencies.Config.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        javaCompileOptions {
            annotationProcessorOptions {
                argument("room.schemaLocation", "$projectDir/schemas".toString())

            }
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }

    packagingOptions {
        resources.excludes.add("META-INF/*")
    }
}

kotlin.sourceSets.all {
    languageSettings.optIn("kotlin.RequiresOptIn")
}

kapt {
    correctErrorTypes = true
}

dependencies {
    //AndroidX
    implementation(Dependencies.Androidx.core)
    //Compose
    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.material)
    implementation(Dependencies.Lifecycle.runtime)
    implementation(Dependencies.Compose.activity)
    //Room
    implementation(Dependencies.Room.runtime)
    kapt(Dependencies.Room.compiler)
    //Navigation
    implementation(Dependencies.Navigation.compose)
    implementation(Dependencies.Navigation.hilt)
    //Firebase
    implementation(platform(Dependencies.Firebase.boom))
    implementation(Dependencies.Firebase.auth)
    implementation(Dependencies.Firebase.storage)
    implementation(Dependencies.Firebase.firestore)
    //Preferences
    implementation(Dependencies.Preferences.datastore)
    //Coroutines
    implementation(Dependencies.Coroutines.services)
    //Serialization
    implementation (Dependencies.Serialization.runtime)
    //Hilt
    implementation(Dependencies.Hilt.hilt)
    kapt(Dependencies.Hilt.hiltKapt)
    //Map
    implementation(Dependencies.Compose.maps)
    implementation(Dependencies.GoogleService.maps)
    //Location
    implementation(Dependencies.GoogleService.location)
    //Test
    testImplementation(Dependencies.Test.junit)
    debugImplementation(Dependencies.DebugTest.uiTooling)
    debugImplementation(Dependencies.DebugTest.uiManifest)
    androidTestImplementation(Dependencies.AndroidTest.junit)
    androidTestImplementation(Dependencies.AndroidTest.uiJunit)
    androidTestImplementation(Dependencies.AndroidTest.espresso)
}

