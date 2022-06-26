package com.atitienei_daniel.recipe.domain.model

data class AnalyzedInstruction(
    val name: String = "",
    val steps: List<Step> = listOf()
)