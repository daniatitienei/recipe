package com.atitienei_daniel.recipe.presentation.screens.discover

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.atitienei_daniel.recipe.R
import com.atitienei_daniel.recipe.databinding.FragmentDiscoverBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DiscoverFragment : Fragment() {

    private val viewModel: DiscoverViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentDiscoverBinding>(
            inflater,
            R.layout.fragment_discover,
            container,
            false
        )

        val adapter = RecipeListAdapter()

        viewModel.recipes.observe(viewLifecycleOwner) { recipes ->
            recipes?.let {
                adapter.recipeList = recipes
            }
        }

        binding.recipeRecyclerView.adapter = adapter
        binding.recipeRecyclerView.layoutManager = GridLayoutManager(context, 2)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.discovery_actions, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.action_search -> {
            true
        }
        else -> super.onOptionsItemSelected(item)
    }


}