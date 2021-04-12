package com.lucas.marvellist.ui.hero_list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.lucas.marvellist.R
import com.lucas.marvellist.databinding.FragmentHeroListBinding

class HeroListFragment : Fragment(R.layout.fragment_hero_list) {

    private val viewModel: HeroListViewModel by viewModels()

    private lateinit var binding: FragmentHeroListBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHeroListBinding.inflate(layoutInflater)

        viewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textHome.text = it
        })
    }
}