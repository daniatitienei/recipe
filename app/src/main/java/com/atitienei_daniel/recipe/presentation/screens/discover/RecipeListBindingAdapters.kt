package com.atitienei_daniel.recipe.presentation.screens.discover

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import com.atitienei_daniel.recipe.data.remote.SpoonacularApi
import com.atitienei_daniel.recipe.domain.model.Recipe

@BindingAdapter("foodImage")
fun ImageView.setImageFromNetwork(item: Recipe) {
    load(
        SpoonacularApi.imageUrl
            .replace("{ID}", item.id.toString())
            .replace("{SIZE}", "636x393")
            .replace("{TYPE}", "jpg")
    )
}