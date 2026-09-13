package com.example.recipeapp.domain.repository

import com.example.recipeapp.data.remote.dto.AddRecipeRequest
import com.example.recipeapp.data.remote.dto.RecipeDTO

interface RecipeRepository {
    suspend fun getAllRecipes(): List<RecipeDTO>
    suspend fun getRecipeById(id: Int): RecipeDTO
}