package com.find.android.core.util.event

sealed class ResponseState<out T> {

    data class Success<T>(val data: T) : ResponseState<T>()

    data class Error<T>(val throwable: Throwable?) : ResponseState<T>()

    object Loading : ResponseState<Nothing>()

    fun onSuccess(handler: (T) -> Unit): ResponseState<T> = this.also {
        if (this is Success) handler(data)
    }

    fun onLoading(handler: () -> Unit): ResponseState<T> = this.also {
        if (this is Loading) handler()
    }

    fun onError(handler: (t: Throwable) -> Unit): ResponseState<T> = this.also {
        if (this is Error) throwable?.let { it1 -> handler(it1) }
    }

    fun onSuccessOrError(handler: () -> Unit): ResponseState<T> = this.also {
        if (this is Success || this is Error) handler()
    }

}