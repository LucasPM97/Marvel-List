package com.lucas.marvellist.ui.character_details.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.lucas.marvellist.R
import com.lucas.marvellist.models.Character

@Composable
fun CharacterDetailsScreen(character: Character) {
    Column(
        Modifier.verticalScroll(
            state = rememberScrollState()
        )
    ) {
        CharacterImage(
            character,
            Modifier
                .fillMaxWidth()
                .height(360.dp)
        )
        Column(
            Modifier
                .padding(top = 20.dp)
                .padding(horizontal = 10.dp)
        ) {

            if (!character.description.isNullOrEmpty()){
                Text(
                    character.description,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp),
                    color = colorResource(id = R.color.description_text_color)
                )
            }

            CharacterComics(
                character
            )
        }
    }
}