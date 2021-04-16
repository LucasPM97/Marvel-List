package com.lucas.marvellist.ui.hero_list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.lucas.marvellist.R
import com.lucas.marvellist.databinding.FragmentHeroListBinding
import com.lucas.marvellist.models.interfaces.IScrollToBottomListener
import com.lucas.marvellist.ui.BaseFragment
import com.lucas.marvellist.utils.extensions.setScrollToBottomListener

class HeroListFragment : BaseFragment(R.layout.fragment_hero_list) {

    private val viewModel: HeroListViewModel by viewModels()

    private val listAdapter = HeroListAdapter(arrayListOf())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        FragmentHeroListBinding.bind(view).apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = this@HeroListFragment.viewModel

            recyclerView.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = listAdapter
                setScrollToBottomListener(5, object : IScrollToBottomListener {
                    override fun bottomReached() {
                        this@HeroListFragment.viewModel.loadMoreItems()
                    }
                })
            }

        }

        implementObservers()
        viewModel.loadScreenIfNeeded()
    }

    private fun implementObservers() {
        viewModel.heroList.observe(viewLifecycleOwner, { heroes ->
            heroes?.let {
                listAdapter.updateList(it)
            }
        })
    }
}