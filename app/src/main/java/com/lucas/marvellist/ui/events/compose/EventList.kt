package com.lucas.marvellist.ui.events.compose

import android.graphics.Bitmap
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lucas.marvellist.models.Event


@ExperimentalAnimationApi
@Composable
fun EventList(
    liveEvents: LiveData<List<Event>>,
    onBottomReached: (() -> Unit)?,
    modifier: Modifier = Modifier
) {

    val events by liveEvents.observeAsState(initial = emptyList())
    val collapsedIndexState = remember { mutableStateOf<Int>(-1) }

    fun itemOnClick(index: Int) {
        collapsedIndexState.value =
            if (collapsedIndexState.value == index) -1
            else index
    }

    LazyColumn(
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
                    .padding(bottom = 9.dp),
                collapsed = collapsedIndexState.value == index,
                onClick = {
                    itemOnClick(index)
                }
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