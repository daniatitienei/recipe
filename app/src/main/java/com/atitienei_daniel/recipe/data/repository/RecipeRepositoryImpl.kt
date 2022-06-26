package com.atitienei_daniel.recipe.data.repository

import com.atitienei_daniel.recipe.data.remote.SpoonacularApi
import com.atitienei_daniel.recipe.domain.model.Recipes
import com.atitienei_daniel.recipe.domain.repository.RecipeRepository
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    private val api: SpoonacularApi
) : RecipeRepository {

    override suspend fun getRandomRecipes(): Recipes = api.getRandomRecipes()
}