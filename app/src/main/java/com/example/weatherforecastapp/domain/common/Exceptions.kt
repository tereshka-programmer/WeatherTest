package com.example.weatherforecastapp.domain.common

open class AppException : RuntimeException {
    constructor() : super()
    constructor(cause: Throwable) : super(cause)
}

class ConnectionException(cause: Throwable) : AppException(cause = cause)

open class BackendException(
    val code: Int,
) : AppException()

class ParseBackendResponseException(
    cause: Throwable
) : AppException(cause = cause)