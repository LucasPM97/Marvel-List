package com.lucas.marvellist.ui.character_details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.lucas.marvellist.R
import com.lucas.marvellist.databinding.CharacterDetailsFragmentBinding

class CharacterDetailsFragment : Fragment(R.layout.character_details_fragment) {

    private val viewModel: CharacterDetailsViewModel by viewModels()

    private val args: CharacterDetailsFragmentArgs? by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = CharacterDetailsFragmentBinding.bind(view)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        args?.let {
            viewModel.setUp(it.character)
        }
    }
}