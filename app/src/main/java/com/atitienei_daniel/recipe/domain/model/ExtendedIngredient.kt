package com.atitienei_daniel.recipe.domain.model

data class ExtendedIngredient(
    val aisle: String? = null,
    val amount: Double = 0.0,
    val consistency: String = "",
    val id: Int = 0,
    val image: String? = null,
    val measures: Measures = Measures(),
    val meta: List<String> = listOf(),
    val name: String = "",
    val nameClean: String? = null,
    val original: String = "",
    val originalName: String = "",
    val unit: String = ""
)