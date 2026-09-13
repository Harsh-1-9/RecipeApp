package com.example.recipeapp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class RecipeResponse(
    val limit: Int,
    val recipes: List<RecipeDTO>,
    val skip: Int,
    val total: Int
)