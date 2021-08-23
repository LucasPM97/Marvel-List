package com.lucas.marvellist.ui.characters.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import com.lucas.marvellist.R
import com.lucas.marvellist.models.Character
import com.lucas.marvellist.ui.composables.GlideImage

@Composable
fun CharacterImage(character: Character, modifier: Modifier) {
    GlideImage(
        imageUrl = character.getSmallImageUrl(),
        contentDescription = "${character.name} image",
        modifier = modifier
            .background(
                colorResource(R.color.image_background_color),
                RoundedCornerShape(
                    topStart = dimensionResource(R.dimen.small_image_corner)
                )
            )
    )
}