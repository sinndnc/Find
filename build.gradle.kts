plugins {
    id(com.find.android.Dependencies.Plugin.application) version "7.2.1" apply false
    id(com.find.android.Dependencies.Plugin.library) version "7.2.1" apply false
    id(com.find.android.Dependencies.Plugin.kotlin) version "1.6.10" apply false
    kotlin(com.find.android.Dependencies.Plugin.jvm) version "1.6.10"
    kotlin(com.find.android.Dependencies.Plugin.serialization) version "1.6.10"
}


buildscript {
    dependencies {
        classpath(com.find.android.Dependencies.Gradle.hilt)
        classpath(com.find.android.Dependencies.Gradle.android)
        classpath(com.find.android.Dependencies.Gradle.googleService)

    }
}
