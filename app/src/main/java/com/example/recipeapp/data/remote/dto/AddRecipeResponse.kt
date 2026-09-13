package com.example.recipeapp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class AddRecipeResponse(
    val caloriesPerServing: Int,
    val cookTimeMinutes: Int,
    val cuisine: String,
    val difficulty: String,
    val ingredients: List<String>,
    val instructions: List<String>,
    val mealType: List<String>,
    val name: String,
    val prepTimeMinutes: Int,
    val servings: Int,
    val tags: List<String>,
)