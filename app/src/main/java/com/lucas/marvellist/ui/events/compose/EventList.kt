package com.lucas.marvellist.ui.events.compose

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lucas.marvellist.models.Event
import kotlinx.coroutines.launch


@ExperimentalAnimationApi
@Composable
fun EventList(
    liveEvents: LiveData<List<Event>>,
    onBottomReached: (() -> Unit)?,
    modifier: Modifier = Modifier
) {

    val listState = rememberLazyListState()
// Remember a CoroutineScope to be able to launch
    val coroutineScope = rememberCoroutineScope()

    val events by liveEvents.observeAsState(initial = emptyList())
    val collapsedIndexState = remember { mutableStateOf<Int>(-1) }

    fun itemOnClick(index: Int) {
        coroutineScope.launch {
            listState.animateScrollToItem(index)

            collapsedIndexState.value =
                if (collapsedIndexState.value == index) -1
                else index

        }
    }

    LazyColumn(
        state = listState,
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        itemsIndexed(events) { index, event ->
            if (index == events.lastIndex) {
                onBottomReached?.let {
                    it()
                }
            }

            EventItem(
                event,
                modifier = Modifier
                    .padding(bottom = 9.dp)
                    .fillMaxWidth()
                    .clickable { itemOnClick(index) },
                collapsed = collapsedIndexState.value == index
            )
        }
    }
}

@ExperimentalAnimationApi
@Composable
@Preview
private fun PreviewEventList() {
    val liveList = MutableLiveData<List<Event>>(
        listOf(
            Event(
                title = "Title Sample",
                start = "1999",
                end = "2000"
            )
        )
    )

    EventList(liveList, null)
}