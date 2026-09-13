package com.example.recipeapp.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.recipeapp.data.remote.dto.RecipeDTO
import com.example.recipeapp.domain.repository.RecipeRepository
import com.example.recipeapp.presentation.navigation.RecipeDetailRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewModel @Inject constructor(
    private val repository: RecipeRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var recipe by mutableStateOf<RecipeDTO?>(null)
        private set

    var isLoading by mutableStateOf(true)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    init {
        // Safe route argument extraction
        val routeArgs = savedStateHandle.toRoute<RecipeDetailRoute>()
        fetchRecipeDetails(routeArgs.recipeId)
    }

    fun fetchRecipeDetails(id: Int) {
        viewModelScope.launch {
            isLoading = true
            errorMessage = null
            try {
                recipe = repository.getRecipeById(id)
            } catch (e: Exception) {
                errorMessage = e.localizedMessage ?: "Something went wrong"
            } finally {
                isLoading = false
            }
        }
    }
}