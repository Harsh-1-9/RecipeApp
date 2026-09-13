package com.example.recipeapp.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeapp.data.remote.dto.RecipeDTO
import com.example.recipeapp.domain.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: RecipeRepository //
) : ViewModel() {

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    var recipes by mutableStateOf<List<RecipeDTO>>(emptyList())
        private set

    var categories by mutableStateOf<List<String>>(listOf("All"))
        private set

    var selectedCategory by mutableStateOf("All")
        private set

    private var allRecipes: List<RecipeDTO> = emptyList()

    init {
        fetchRecipes()
    }

    fun fetchRecipes() {
        isLoading = true
        errorMessage = null
        viewModelScope.launch {
            try {
                val result = repository.getAllRecipes()
                allRecipes = result
                val cuisine = result.map {
                    it.cuisine
                }.distinct().sorted()
                categories = listOf("All") + cuisine
                applyFilter()
            } catch (e: Exception) {
                errorMessage = e.message ?: "Something went wrong"
            } finally {
                isLoading = false
            }
        }
    }

    fun onCategorySelected(category: String) {
        selectedCategory = category
        applyFilter()
    }

    private fun applyFilter() {
        recipes = if (selectedCategory == "All") {
            allRecipes
        } else {
            allRecipes.filter {
                it.cuisine == selectedCategory
            }
        }
    }
}