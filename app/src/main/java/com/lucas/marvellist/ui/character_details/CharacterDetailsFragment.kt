package com.lucas.marvellist.ui.character_details

import android.os.Bundle
import android.view.View
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.navigation.fragment.navArgs
import com.lucas.marvellist.R
import com.lucas.marvellist.databinding.CharacterDetailsFragmentBinding
import com.lucas.marvellist.ui.BaseFragment
import com.lucas.marvellist.ui.character_details.compose.CharacterDetailsScreen

class CharacterDetailsFragment : BaseFragment(R.layout.character_details_fragment) {

    private val args: CharacterDetailsFragmentArgs? by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        CharacterDetailsFragmentBinding.bind(view).apply {
            args?.let {
                root.apply {
                    // Dispose the Composition when viewLifecycleOwner is destroyed
                    setViewCompositionStrategy(
                        ViewCompositionStrategy.DisposeOnLifecycleDestroyed(viewLifecycleOwner)
                    )
                    setContent {
                        CharacterDetailsScreen(character = it.character)
                    }
                }
            }
        }

    }
}