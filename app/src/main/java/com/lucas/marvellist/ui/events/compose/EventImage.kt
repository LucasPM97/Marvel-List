package com.lucas.marvellist.ui.events.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import com.lucas.marvellist.R
import com.lucas.marvellist.models.Event
import com.lucas.marvellist.ui.composables.GlideImage

@Composable
fun EventImage(event: Event, modifier: Modifier = Modifier) {
    GlideImage(
        imageUrl = event.getSmallImageUrl(),
        contentDescription = "${event.title} image",
        modifier = modifier
            .background(
                colorResource(R.color.image_background_color),
                shape = RoundedCornerShape(
                    bottomStart = dimensionResource(R.dimen.small_image_corner),
                    topStart = dimensionResource(R.dimen.small_image_corner)
                )
            )
    )
}