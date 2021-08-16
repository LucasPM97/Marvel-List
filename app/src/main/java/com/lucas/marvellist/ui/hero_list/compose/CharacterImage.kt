package com.lucas.marvellist.ui.hero_list.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import com.lucas.marvellist.R
import com.lucas.marvellist.models.Character
import com.lucas.marvellist.ui.composables.loadPicture

@Composable
fun CharacterImage(character: Character, modifier: Modifier) {
    val imageState = loadPicture(character.getSmallImageUrl())
    imageState.value?.let { bitmap ->
        Image(
            bitmap = bitmap.asImageBitmap(),
            contentDescription = "${character.name} image",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .background(
                    colorResource(R.color.image_background_color),
                    RoundedCornerShape(
                        topStart = dimensionResource(R.dimen.small_image_corner)
                    )
                )
        )
    }
}