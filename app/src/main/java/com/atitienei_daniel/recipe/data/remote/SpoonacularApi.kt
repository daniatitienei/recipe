package com.atitienei_daniel.recipe.data.remote

import com.atitienei_daniel.recipe.BuildConfig
import com.atitienei_daniel.recipe.domain.model.Recipes
import retrofit2.http.GET
import retrofit2.http.Query

interface SpoonacularApi {

    @GET("recipes/random")
    suspend fun getRandomRecipes(
        @Query("number") number: Int = 1,
        @Query("apiKey") apiKey: String = SpoonacularApi.apiKey
    ): Recipes

    companion object {
        const val url = "https://api.spoonacular.com/"
        const val apiKey = BuildConfig.SPOONACULAR_KEY
        const val imageUrl = "https://spoonacular.com/recipeImages/{ID}-{SIZE}.{TYPE}"
    }
}