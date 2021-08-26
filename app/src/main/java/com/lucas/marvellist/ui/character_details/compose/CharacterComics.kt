package com.lucas.marvellist.ui.character_details.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import com.lucas.marvellist.R
import com.lucas.marvellist.models.Character
import com.lucas.marvellist.ui.composables.ComicList
import com.lucas.marvellist.utils.extensions.fontDimensionResource

@Composable
fun CharacterComics(
    character: Character,
    modifier: Modifier = Modifier
) {
    character.comics?.let { comics ->
        Column(modifier = modifier) {
            Text(
                stringResource(id = R.string.character_details_comics_title)
                    .uppercase(),
                fontFamily = FontFamily.SansSerif,
                color = colorResource(id = R.color.black),
                fontSize = fontDimensionResource(R.dimen.comics_title_text_size)
            )
            ComicList(
                comics
            )
        }
    }
}