package com.example.pawpal.navigation

sealed class AppScreens(val route: String) {
    object MoviesScreen: AppScreens("movies_screen")
    object MovieScreen: AppScreens("movie_screen/{id}") {
        fun createRoute(id: Int) = "movie_screen/$id"
    }
    object AboutScreen: AppScreens("about")


}