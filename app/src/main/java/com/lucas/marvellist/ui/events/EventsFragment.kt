package com.lucas.marvellist.ui.events

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.lucas.marvellist.R
import com.lucas.marvellist.databinding.FragmentEventsBinding
import com.lucas.marvellist.models.interfaces.IScrollToBottomListener
import com.lucas.marvellist.utils.extensions.setScrollToBottomListener

class EventsFragment : Fragment(R.layout.fragment_events) {

    private val viewModel: EventsViewModel by viewModels()

    private val listAdapter = EventsAdapter(arrayListOf())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentEventsBinding.bind(view)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = listAdapter
            setScrollToBottomListener(5, object : IScrollToBottomListener {
                override fun bottomReached() {
                    viewModel.loadMoreItems()
                }
            })
        }

        implementObservers()
        viewModel.loadScreenIfNeeded()
    }

    private fun implementObservers() {
        viewModel.eventList.observe(viewLifecycleOwner, { events ->
            events?.let {
                listAdapter.updateList(it)
            }
        })
    }
}