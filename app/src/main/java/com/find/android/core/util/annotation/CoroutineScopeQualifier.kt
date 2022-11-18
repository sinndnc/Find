package com.find.android.core.util.annotation

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DefaultCoroutineScope

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class IoCoroutineScope

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MainCoroutineScope