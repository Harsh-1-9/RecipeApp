package com.example.recipeapp.presentation.screens.recipe_details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.recipeapp.presentation.components.ErrorMessage
import com.example.recipeapp.presentation.components.LoadingIndicator
import com.example.recipeapp.presentation.components.MyTopbar
import com.example.recipeapp.presentation.viewmodels.RecipeDetailViewModel
import com.example.recipeapp.ui.theme.myOrange

@Composable
fun RecipeDetailScreen(
    onBack: () -> Unit,
    viewModel: RecipeDetailViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            MyTopbar(
                title = "Recipe Details",
                onBackClick = onBack,
                icon = Icons.AutoMirrored.Filled.ArrowBack
            )
        }
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(myOrange.copy(alpha = 0.02f))
        ) {
            when {
                viewModel.isLoading -> LoadingIndicator(strokeWidth = 1.dp)

                viewModel.errorMessage != null -> ErrorMessage(
                    errorMessage = viewModel.errorMessage ?: "An unexpected error occurred",
                    onRetry = {
                        viewModel.recipe?.id?.let { id -> viewModel.fetchRecipeDetails(id) }
                    }
                )

                viewModel.recipe != null -> {
                    viewModel.recipe?.let { recipe ->
                        RecipeDetailContent(details = recipe)
                    }
                }
            }
        }
    }
}