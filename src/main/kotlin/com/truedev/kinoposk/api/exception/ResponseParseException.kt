package com.truedev.kinoposk.api.exception

class ResponseParseException : Exception {
    constructor() {}

    constructor(message: String) : super(message) {}

    constructor(cause: Throwable) : super(cause) {}

    constructor(message: String, cause: Throwable) : super(message, cause) {}
}
