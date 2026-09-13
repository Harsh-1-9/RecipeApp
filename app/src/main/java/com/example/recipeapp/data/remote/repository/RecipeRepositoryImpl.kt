package com.example.recipeapp.data.remote.repository

import com.example.recipeapp.data.remote.RecipeAPIService
import com.example.recipeapp.data.remote.dto.AddRecipeRequest
import com.example.recipeapp.data.remote.dto.RecipeDTO
import com.example.recipeapp.domain.repository.RecipeRepository
import jakarta.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    private val apiService: RecipeAPIService
) : RecipeRepository {
    override suspend fun getAllRecipes(): List<RecipeDTO> {
        return apiService.getAllRecipes().recipes
    }
    override suspend fun getRecipeById(id: Int): RecipeDTO {
        return apiService.getRecipeById(id)
    }
}