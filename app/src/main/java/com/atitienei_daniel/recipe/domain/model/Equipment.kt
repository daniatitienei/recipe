package com.atitienei_daniel.recipe.domain.model

data class Equipment(
    val id: Int = 0,
    val image: String = "",
    val localizedName: String = "",
    val name: String = "",
    val temperature: Temperature? = null
)