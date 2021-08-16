package com.lucas.marvellist.ui.hero_list.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lucas.marvellist.models.Character


@Composable
fun CharacterItem(character: Character, modifier: Modifier, onClick: (Character) -> Unit) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick(character) }
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            shape = RoundedCornerShape(4.dp)
        ) {
            Row {
                CharacterImage(
                    character,
                    modifier = Modifier
                        .size(120.dp)
                )
                CharacterInfo(
                    character,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 16.dp, end = 30.dp, bottom = 28.dp)
                )
            }

        }
    }
}

@Composable
@Preview
private fun PreviewCharacterItem() {
    CharacterItem(
        character = Character(
            name = "Stan lee",
            description = "Description sample"
        ),
        modifier = Modifier,
        onClick = {

        })
}