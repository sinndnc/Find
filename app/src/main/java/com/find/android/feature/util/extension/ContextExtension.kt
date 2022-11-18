package com.find.android.feature.util.extension

import android.net.ConnectivityManager
import android.net.NetworkCapabilities

fun ConnectivityManager.hasInternet(): Boolean {
    val capabilities = this.getNetworkCapabilities(this.activeNetwork)
    capabilities?.let {
        return when {
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }
    return false
}

