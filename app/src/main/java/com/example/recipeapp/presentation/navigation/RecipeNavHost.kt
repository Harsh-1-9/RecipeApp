package com.example.recipeapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.recipeapp.presentation.screens.home.HomeScreen
import com.example.recipeapp.presentation.screens.recipe_details.RecipeDetailScreen

@Composable
fun RecipeNavHost(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HomeRoute,
        modifier = modifier
    ) {
        // Home / Recipes List Screen
        composable<HomeRoute> {
            HomeScreen(
                onRecipeClick = { recipeId ->
                    navController.navigate(route = RecipeDetailRoute(recipeId = recipeId))
                }
            )
        }

        // Recipe Detail Screen
        composable<RecipeDetailRoute> { backStackEntry ->
            val routeArgs = backStackEntry.toRoute<RecipeDetailRoute>()

            RecipeDetailScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}