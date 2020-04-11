package com.truedev.kinoposk.api.model.navigator.filter

enum class Order(val queryNameParam: String) {
    RATING("rating"), NUM_VOTE("num_vote"), YEAR("year");
}
