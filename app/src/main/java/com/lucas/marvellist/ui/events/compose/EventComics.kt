package com.lucas.marvellist.ui.events.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.lucas.marvellist.R
import com.lucas.marvellist.models.Event
import com.lucas.marvellist.ui.composables.ComicList
import com.lucas.marvellist.utils.extensions.fontDimensionResource

@Composable
fun EventComics(
    event: Event,
    collapsed: Boolean
) {
    event.comics?.let {
        if (collapsed) {
            Column {
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