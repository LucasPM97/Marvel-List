package com.lucas.marvellist.ui.composables

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.lucas.marvellist.R

@Composable
fun loadPicture(
    imageUrl: String,
    @DrawableRes defaultImage : Int =  R.drawable.stan_lee) : MutableState<Bitmap?> {

    val bitmapState = remember { mutableStateOf<Bitmap?>(null)}

    Glide.with(LocalContext.current)
        .asBitmap()
        .placeholder(defaultImage)
        .load(imageUrl)
        .into(object : CustomTarget<Bitmap>(){
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                  bitmapState.value = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {
            }

        })

    return bitmapState
}