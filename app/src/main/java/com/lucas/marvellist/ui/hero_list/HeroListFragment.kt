package com.lucas.marvellist.ui.hero_list

import android.os.Bundle
import android.view.View
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.lucas.marvellist.R
import com.lucas.marvellist.databinding.FragmentHeroListBinding
import com.lucas.marvellist.ui.BaseFragment
import com.lucas.marvellist.ui.hero_list.compose.HeroListScreen

class HeroListFragment : BaseFragment(R.layout.fragment_hero_list) {

    private val viewModel: HeroListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        FragmentHeroListBinding.bind(view).apply {
            composeScreen.apply {
                // Dispose the Composition when viewLifecycleOwner is destroyed
                setViewCompositionStrategy(
                    ViewCompositionStrategy.DisposeOnLifecycleDestroyed(viewLifecycleOwner)
                )
                setContent {
                    HeroListScreen(viewModel, findNavController())
                }
            }
        }

        viewModel.loadScreenIfNeeded()
    }
}