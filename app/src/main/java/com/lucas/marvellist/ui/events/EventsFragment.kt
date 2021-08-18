package com.lucas.marvellist.ui.events

import android.os.Bundle
import android.view.View
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.viewModels
import com.lucas.marvellist.R
import com.lucas.marvellist.databinding.FragmentEventsBinding
import com.lucas.marvellist.ui.BaseFragment
import com.lucas.marvellist.ui.events.compose.EventsScreen

class EventsFragment : BaseFragment(R.layout.fragment_events) {

    private val viewModel: EventsViewModel by viewModels()

    @ExperimentalAnimationApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        FragmentEventsBinding.bind(view).apply {
            root.apply {
                // Dispose the Composition when viewLifecycleOwner is destroyed
                setViewCompositionStrategy(
                    ViewCompositionStrategy.DisposeOnLifecycleDestroyed(viewLifecycleOwner)
                )
                setContent {
                    EventsScreen(viewModel = viewModel)
                }
            }
        }

        viewModel.loadScreenIfNeeded()
    }
}