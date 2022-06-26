package com.atitienei_daniel.recipe.presentation.screens.discover

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.atitienei_daniel.recipe.databinding.FoodCardBinding
import com.atitienei_daniel.recipe.domain.model.Recipe

class RecipeListAdapter :
    RecyclerView.Adapter<RecipeListAdapter.ViewHolder>() {

    var recipeList = listOf<Recipe>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = recipeList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = recipeList.size

    class ViewHolder private constructor(val binding: FoodCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(recipe: Recipe) {
            binding.recipe = recipe
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = FoodCardBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }
}