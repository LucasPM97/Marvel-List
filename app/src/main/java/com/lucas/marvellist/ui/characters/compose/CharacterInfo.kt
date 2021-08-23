package com.lucas.marvellist.ui.characters.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.lucas.marvellist.R
import com.lucas.marvellist.models.Character
import com.lucas.marvellist.utils.extensions.fontDimensionResource

@Composable
fun CharacterInfo(character: Character, modifier: Modifier) {
    Column(
        modifier = modifier
    ) {
        Text(
            (character.name ?: "").uppercase(),
            fontSize = fontDimensionResource(R.dimen.title_font_size),
            color = colorResource(R.color.black),
            fontFamily = FontFamily.SansSerif
        )
        Spacer(modifier = androidx.compose.ui.Modifier.height(9.dp))
        Text(
            character.description ?: "",
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            color = colorResource(R.color.description_text_color),
            fontSize = fontDimensionResource(R.dimen.description_font_size)
        )
    }
}