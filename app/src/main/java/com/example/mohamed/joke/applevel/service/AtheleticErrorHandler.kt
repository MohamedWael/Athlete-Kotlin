package com.example.mohamed.joke.applevel.service

import com.example.mohamed.joke.R
import com.example.mohamed.joke.base.service.ErrorHandler
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException

class AtheleticErrorHandler(throwable: Throwable?) : ErrorHandler {
    private var throwable = throwable

    override fun getStringRes(): Int {
        return propareErrorMessage()
    }

    override fun getString(): String {
        return ""
    }

    private fun propareErrorMessage(): Int {
        return when (throwable) {
            is UnknownHostException -> R.string.connection_error
            is TimeoutException -> R.string.connection_error
            is SocketTimeoutException -> R.string.connection_error
            else -> R.string.something_error
        }
    }
}