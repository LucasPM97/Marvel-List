package com.lucas.marvellist.ui.events.compose

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lucas.marvellist.ui.composables.ListProgressBar
import com.lucas.marvellist.ui.events.EventsViewModel

@ExperimentalAnimationApi
@Composable
fun EventsScreen(viewModel: EventsViewModel) {
    Column {
        ListProgressBar(
            isLoadingLive = viewModel.isLoading,
            modifier = Modifier.fillMaxWidth()
        )
        EventList(
            liveEvents = viewModel.eventList,
            onBottomReached = {
                viewModel.loadMoreItems()
            },
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp)
                .padding(top = 10.dp),
        )
    }
}