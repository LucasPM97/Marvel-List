package com.lucas.marvellist.ui.composables

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.lucas.marvellist.R
import com.lucas.marvellist.models.Character

@Composable
fun loadPicture(
    imageUrl: String,
    @DrawableRes defaultImage: Int = R.drawable.stan_lee
): MutableState<Bitmap?> {

    val bitmapState = remember { mutableStateOf<Bitmap?>(null) }

    Glide.with(LocalContext.current)
        .asBitmap()
        .placeholder(defaultImage)
        .load(imageUrl)
        .into(object : CustomTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitmapState.value = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {
            }

        })

    return bitmapState
}

@Composable
fun GlideImage(imageUrl: String, contentDescription: String, modifier: Modifier) {
    Box(
        modifier = modifier
            .background(
                colorResource(R.color.image_background_color),
            )
    ) {
        val imageState = loadPicture(imageUrl)
        imageState.value?.let { bitmap ->
            Image(
                bitmap = bitmap.asImageBitmap(),
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )
        }

    }
}