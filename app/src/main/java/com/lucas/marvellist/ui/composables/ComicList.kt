package com.lucas.marvellist.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lucas.marvellist.models.ComicCollection

@Composable
fun ComicList(
    comicList: ComicCollection,
    modifier: Modifier = Modifier
) {
    comicList.items?.let {
        if (comicList.items.size == 0) return

        Column(
            modifier = modifier
        ) {

            repeat(comicList.items.size) { index ->
                ComicItem(
                    comicList.items.elementAt(index),
                    modifier = Modifier
                        .padding(bottom = 9.dp)
                )
            }
        }
    }
}