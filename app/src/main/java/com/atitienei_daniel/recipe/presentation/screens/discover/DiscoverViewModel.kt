package com.atitienei_daniel.recipe.presentation.screens.discover

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atitienei_daniel.recipe.domain.model.Recipe
import com.atitienei_daniel.recipe.domain.use_case.GetRandomRecipes
import com.atitienei_daniel.recipe.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DiscoverViewModel @Inject constructor(
    private val getRandomRecipes: GetRandomRecipes
) : ViewModel() {

    private var _recipes = MutableLiveData<List<Recipe>>(listOf())
    val recipes: LiveData<List<Recipe>> = _recipes

    init {
        getRecipes()
    }

    private fun getRecipes() {
        getRandomRecipes().onEach { resource ->
            when (resource) {
                is Resource.Success -> {
                    _recipes.value = resource.data ?: listOf()
                    Log.d("recipes", _recipes.value.toString())
                }
                else -> Unit
            }
        }.launchIn(viewModelScope)
    }
}