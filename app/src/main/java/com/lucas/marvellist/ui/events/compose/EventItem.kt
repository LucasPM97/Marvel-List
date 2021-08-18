package com.lucas.marvellist.ui.events.compose

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lucas.marvellist.models.Event

@ExperimentalAnimationApi
@Composable
fun EventItem(
    event: Event,
    modifier: Modifier = Modifier,
    collapsed: Boolean,
    onClick: (Event) -> Unit
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick(event) },
        shape = RoundedCornerShape(4.dp)
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
            ) {
                EventImage(event)
                EventInfo(event)
            }

            EventComics(
                event,
                collapsed = collapsed
            )
        }
    }
}

@ExperimentalAnimationApi
@Composable
@Preview
fun PreviewEventItem() {
    EventItem(
        event = Event(
            title = "Title Sample",
            start = "1999",
            end = "2000"
        ),
        collapsed = true,
        onClick = {

        }
    )
}