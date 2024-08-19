package com.example.pawpal.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.NavType.Companion.StringType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ra.data.movies
import com.example.ra.screens.AboutScreen
import com.example.ra.screens.MovieDetailScreen
import com.example.ra.screens.MoviesScreen


@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.MoviesScreen.route) {

        composable(route = AppScreens.MoviesScreen.route) {
            MoviesScreen(movies, navController)
        }

        composable(
            route = AppScreens.MovieScreen.route,
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id")
            id?.let {
                MovieDetailScreen(navController, id)
            }
        }

        composable(route = AppScreens.AboutScreen.route) {
            AboutScreen(navController)
        }
    }
}