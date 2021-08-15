package com.lucas.marvellist.ui.hero_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lucas.marvellist.models.Character
import com.lucas.marvellist.R
import com.lucas.marvellist.utils.extensions.fontDimensionResource


@Composable
fun HeroItem(character: Character, modifier: Modifier, onClick: (Character) -> Unit) {
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
                Image(
                    painter = painterResource(R.drawable.stan_lee),
                    contentDescription = "${character.name} image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(120.dp)
                        .background(
                            colorResource(R.color.image_background_color),
                            RoundedCornerShape(
                                topStart = dimensionResource(R.dimen.small_image_corner)
                            )
                        )
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 16.dp, end = 30.dp, bottom = 28.dp)
                ) {
                    Text(
                        (character.name ?: "").uppercase(),
                        fontSize = fontDimensionResource(R.dimen.title_font_size),
                        color = colorResource(R.color.black),
                        fontFamily = FontFamily.SansSerif
                    )
                    Spacer(modifier = Modifier.height(9.dp))
                    Text(
                        character.description ?: "",
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        color = colorResource(R.color.description_text_color),
                        fontSize = fontDimensionResource(R.dimen.description_font_size)
                    )
                }

            }

        }
    }
}

@Composable
@Preview
private fun PreviewHeroItem() {
    HeroItem(
        character = Character(
            name = "Stan lee",
            description = "Description sample"
        ),
        modifier = Modifier,
        onClick = {

        })
}