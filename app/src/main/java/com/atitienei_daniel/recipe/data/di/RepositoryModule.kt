package com.atitienei_daniel.recipe.data.di

import com.atitienei_daniel.recipe.data.remote.SpoonacularApi
import com.atitienei_daniel.recipe.data.repository.RecipeRepositoryImpl
import com.atitienei_daniel.recipe.domain.repository.RecipeRepository
import com.atitienei_daniel.recipe.domain.use_case.GetRandomRecipes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesRecipeRepository(api: SpoonacularApi): RecipeRepository = RecipeRepositoryImpl(api)

    @Provides
    @Singleton
    fun providesUseCase(repository: RecipeRepository): GetRandomRecipes =
        GetRandomRecipes(repository)
}