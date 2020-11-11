package com.project.segunfrancis.cleancoin.utils

import java.io.IOException
import java.net.UnknownHostException

/**
 * Created by SegunFrancis
 */

sealed class Result<out R> {
    data class Success<out T>(val data: T? = null) : Result<T>()

    data class Error(val error: Throwable) : Result<Nothing>() {
        val formattedError: String
            get() = when (error) {
                is UnknownHostException -> {
                    "Make sure you are connected to a network"
                }
                is IOException -> {
                    "Your network might be slow"
                }
                else -> {
                    "Something went wrong"
                }
            }
    }

    object Loading : Result<Nothing>()
}