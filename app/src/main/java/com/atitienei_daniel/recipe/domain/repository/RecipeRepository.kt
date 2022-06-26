package com.atitienei_daniel.recipe.domain.repository

import com.atitienei_daniel.recipe.domain.model.Recipes


interface RecipeRepository {
    suspend fun getRandomRecipes(): Recipes
}