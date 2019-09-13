package com.truedev.kinoposk.api.exception

import java.lang.Exception

class NotFoundException : Exception {
    constructor() {}

    constructor(message: String) : super(message) {}

    constructor(cause: Throwable) : super(cause) {}

    constructor(message: String, cause: Throwable) : super(message, cause) {}
}
