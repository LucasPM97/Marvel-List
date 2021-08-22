package com.lucas.marvellist.ui.events.compose

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lucas.marvellist.models.Event
import com.lucas.marvellist.models.ImageThumbnail

@ExperimentalAnimationApi
@Composable
fun EventItem(
    event: Event,
    modifier: Modifier = Modifier,
    collapsed: Boolean
) {

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(
                    start = 17.dp,
                    top = 17.dp,
                    end = 10.dp
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
            ) {
                EventImage(
                    event,
                    modifier = Modifier
                        .size(86.dp)
                        .padding(
                            bottom = 17.dp
                        )
                )
                EventInfo(
                    event,
                    modifier = Modifier
                        .padding(
                            start = 33.dp
                        )
                )
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
            title = "Event Title",
            start = "1989-12-10 00:00:00",
            end = "2008-01-04 00:00:00",
            thumbnail = ImageThumbnail(
                path = "http://i.annihil.us/u/prod/marvel/i/mg/3/40/4bb4680432f73",
                extension = "jpg"
            )
        ),
        collapsed = true
    )
}