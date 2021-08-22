package com.lucas.marvellist.ui.character_details.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.lucas.marvellist.R
import com.lucas.marvellist.models.Character

@Composable
fun CharacterDetailsScreen(character: Character) {
    Column() {
        CharacterImage(
            character,
            Modifier
                .fillMaxWidth()
                .height(360.dp)
        )
        Text(
            character.description ?: "",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 46.dp),
            color = colorResource(id = R.color.description_text_color)
        )

        CharacterComics(
            character,
            Modifier.padding(top = 9.dp)
        )
    }
}