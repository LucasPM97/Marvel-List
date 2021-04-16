package com.lucas.marvellist.ui.character_details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.lucas.marvellist.R
import com.lucas.marvellist.databinding.CharacterDetailsFragmentBinding
import com.lucas.marvellist.ui.components.adapters.ComicListAdapter

class CharacterDetailsFragment : Fragment(R.layout.character_details_fragment) {

    private val args: CharacterDetailsFragmentArgs? by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        CharacterDetailsFragmentBinding.bind(view).apply {
            lifecycleOwner = viewLifecycleOwner

            args?.let {

                recyclerView.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = ComicListAdapter(it.character.comics?.items ?: emptyList())
                    addItemDecoration(
                        DividerItemDecoration(
                            context,
                            DividerItemDecoration.VERTICAL
                        )
                    )
                }

                character = it.character
            }
        }

    }
}