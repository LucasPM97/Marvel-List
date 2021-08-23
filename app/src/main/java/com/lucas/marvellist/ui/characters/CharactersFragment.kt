package com.lucas.marvellist.ui.characters

import android.os.Bundle
import android.view.View
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.lucas.marvellist.R
import com.lucas.marvellist.databinding.FragmentCharactersBinding
import com.lucas.marvellist.ui.BaseFragment
import com.lucas.marvellist.ui.characters.compose.CharactersScreen

class CharactersFragment : BaseFragment(R.layout.fragment_characters) {

    private val viewModel: CharactersViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        FragmentCharactersBinding.bind(view).apply {
            composeScreen.apply {
                // Dispose the Composition when viewLifecycleOwner is destroyed
                setViewCompositionStrategy(
                    ViewCompositionStrategy.DisposeOnLifecycleDestroyed(viewLifecycleOwner)
                )
                setContent {
                    CharactersScreen(viewModel, findNavController())
                }
            }
        }

        viewModel.loadScreenIfNeeded()
    }
}