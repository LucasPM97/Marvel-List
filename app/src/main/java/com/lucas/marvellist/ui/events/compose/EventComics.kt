package com.lucas.marvellist.ui.events.compose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.lucas.marvellist.R
import com.lucas.marvellist.models.Comic
import com.lucas.marvellist.models.ComicCollection
import com.lucas.marvellist.models.Event
import com.lucas.marvellist.ui.composables.ComicList
import com.lucas.marvellist.utils.extensions.fontDimensionResource

@ExperimentalAnimationApi
@Composable
fun EventComics(
    event: Event,
    collapsed: Boolean,
    modifier: Modifier = Modifier
) {
    event.comics?.let { comics ->
        if (!comics.items.isNullOrEmpty()) {
            AnimatedVisibility(visible = collapsed) {
                Column(modifier = modifier) {
                    Text(
                        text = stringResource(
                            R.string.event_comics_title
                        ).uppercase(),
                        color = Color.Black,
                        fontSize = fontDimensionResource(R.dimen.comics_title_text_size)
                    )
                    ComicList(
                        event.comics
                    )
                }
            }
        }
    }
}


@ExperimentalAnimationApi
@Composable
@Preview
fun PreviewEventComics() {
    EventComics(
        event = Event(
            "","","",
            comics = ComicCollection(
                items = listOf(
                    Comic(
                        name = "Name Sample (2011)"
                    ),
                    Comic(
                        name = "Name Sample2 (2011)"
                    )
                )
            )
        ),
        collapsed = true
    )
}