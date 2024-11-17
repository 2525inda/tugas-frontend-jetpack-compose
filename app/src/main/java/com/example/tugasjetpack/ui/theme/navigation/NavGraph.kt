package com.example.tugasjetpack.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.tugasjetpack.ui.theme.home.AboutScreen
import com.example.tugasjetpack.ui.theme.home.DetailScreen
import com.example.tugasjetpack.ui.theme.home.PageListScreen
import com.example.tugasjetpack.ui.theme.home.LazyGridScreen // Import LazyGridScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "page_list"
    ) {
        composable("page_list") {
            PageListScreen(navController)
        }

        // Define the route and arguments for DetailScreen
        composable(
            "detail_screen/{foodImage}/{title}/{description}",
            arguments = listOf(
                navArgument("foodImage") { type = NavType.IntType },
                navArgument("title") { type = NavType.StringType },
                navArgument("description") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val foodImage = backStackEntry.arguments?.getInt("foodImage") ?: 0
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val description = backStackEntry.arguments?.getString("description") ?: ""
            DetailScreen(foodImage, title, description)
        }

        // LazyGridScreen route
        composable("lazy_grid_screen") {
            LazyGridScreen(navController)
        }

        composable("about_screen") {
            AboutScreen()
        }
    }
}
