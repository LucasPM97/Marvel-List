package com.lucas.marvellist.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lucas.marvellist.models.Comic
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

@Composable
@Preview
fun PreviewComicList() {
    ComicList(
        comicList = ComicCollection(
            items = listOf(
                Comic(
                    name = "Name Sample (2011)"
                ),
                Comic(
                    name = "Name Sample2 (2011)"
                )
            )
        )
    )
}