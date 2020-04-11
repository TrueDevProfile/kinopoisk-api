package com.truedev.kinoposk.api.model.top

enum class Type(val type: String) {
    POPULAR_FILMS("kp_item_top_popular_films"),
    BEST_FILMS("kp_item_top_best_films"),
    BEST_FILMS_LIST("kp_item_top_best_films_list"),
    AWAIT_FILMS("kp_item_top_await")
}
