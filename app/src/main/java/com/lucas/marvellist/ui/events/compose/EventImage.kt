package com.lucas.marvellist.ui.events.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.lucas.marvellist.R
import com.lucas.marvellist.models.Event
import com.lucas.marvellist.ui.composables.GlideImage

@Composable
fun EventImage(event: Event) {
    GlideImage(
        imageUrl = event.getSmallImageUrl(),
        contentDescription = "${event.title} image",
        modifier = Modifier
            .size(86.dp)
            .padding(
                start = 17.dp,
                top = 17.dp,
                bottom = 17.dp
            )
            .background(
                colorResource(R.color.image_background_color),
                shape = RoundedCornerShape(
                    bottomStart = dimensionResource(R.dimen.small_image_corner),
                    topStart = dimensionResource(R.dimen.small_image_corner)
                )
            )
    )
}