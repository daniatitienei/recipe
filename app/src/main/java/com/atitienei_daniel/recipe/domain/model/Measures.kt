package com.atitienei_daniel.recipe.domain.model

data class Measures(
    val metric: Metric = Metric(),
    val us: Us = Us()
)