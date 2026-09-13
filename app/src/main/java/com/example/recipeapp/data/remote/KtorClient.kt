package com.example.recipeapp.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object KtorClient {
    val client = HttpClient(Android) {
        install(ContentNegotiation) {
            json(
                Json{
                    ignoreUnknownKeys = true
                }
            )
        }
    }
     const val BASE_URL = "https://dummyjson.com/"
//    const val RECIPE = "$BASE_URL/recipe"

}