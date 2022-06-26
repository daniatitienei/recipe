package com.atitienei_daniel.recipe.domain.use_case

import com.atitienei_daniel.recipe.domain.model.Recipe
import com.atitienei_daniel.recipe.domain.repository.RecipeRepository
import com.atitienei_daniel.recipe.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetRandomRecipes @Inject constructor(
    private val repository: RecipeRepository
) {
    operator fun invoke(): Flow<Resource<List<Recipe>>> = flow {
        try {
            emit(Resource.Loading<List<Recipe>>())
            val response = repository.getRandomRecipes()

            emit(Resource.Success<List<Recipe>>(response.recipes))

        } catch (e: HttpException) {
            emit(Resource.Error<List<Recipe>>(e))
        } catch (e: IOException) {
            emit(Resource.Error<List<Recipe>>(e))
        }
    }
}