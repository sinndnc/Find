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

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        // ...
        freeCompilerArgs = freeCompilerArgs + "-opt-in=kotlin.RequiresOptIn"
    }
}
kapt {
    correctErrorTypes = true
}

dependencies {
    //AndroidX
    implementation(Dependencies.Androidx.core)
    //Compose
    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.activity)
    implementation(Dependencies.Compose.material)
    implementation(Dependencies.Lifecycle.runtime)
    //Room
    kapt(Dependencies.Room.compiler)
    implementation(Dependencies.Room.runtime)
    //Navigation
    implementation(Dependencies.Navigation.hilt)
    implementation(Dependencies.Navigation.compose)
    //Firebase
    implementation(platform(Dependencies.Firebase.boom))
    implementation(Dependencies.Firebase.auth)
    implementation(Dependencies.Firebase.storage)
    implementation(Dependencies.Firebase.bootAware)
    implementation(Dependencies.Firebase.messaging)
    implementation(Dependencies.Firebase.analytics)
    implementation(Dependencies.Firebase.firestore)
    //WorkManager
    implementation(Dependencies.WorkManager.runtime)
    //Coroutines
    implementation(Dependencies.Coroutines.services)
    //Preferences
    implementation(Dependencies.Preferences.datastore)
    //Serialization
    implementation(Dependencies.Serialization.runtime)
    implementation(Dependencies.Serialization.gson)
    //Hilt
    kapt(Dependencies.Hilt.hiltKapt)
    kapt(Dependencies.Hilt.hiltCompiler)
    implementation(Dependencies.Hilt.hilt)
    implementation(Dependencies.Hilt.workManager)
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

