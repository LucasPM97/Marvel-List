package com.lucas.marvellist.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lucas.marvellist.R
import com.lucas.marvellist.models.Comic
import com.lucas.marvellist.utils.extensions.color

@Composable
fun ComicItem(comic: Comic, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = comic.name ?: "",
            color = colorResource(id = R.color.black),
            fontSize = 16.sp,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    top = 32.dp
                )
        )
        Text(
            text = comic.getComicYear(),
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    top = 10.dp,
                    bottom = 20.dp
                ),
            color = "#666666".color()
        )
    }
}

@Composable
@Preview
fun PreviewComicItem() {
    ComicItem(comic = Comic(
        name = "Name Sample (2011)"
    ))
}