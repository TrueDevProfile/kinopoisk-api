package com.truedev.kinoposk.api.exception

/**
 * Represent general api exception
 */
class BadResponseException : Exception {
    constructor() {}

    constructor(message: String) : super(message) {}

    constructor(cause: Throwable) : super(cause) {}

    constructor(message: String, cause: Throwable) : super(message, cause) {}
}
