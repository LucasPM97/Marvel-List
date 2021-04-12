package com.lucas.marvellist.utils.extensions

import android.widget.ImageView
import androidx.databinding.BindingAdapter

//ImageView
@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String?) {
    url?.let {
        view.loadFromUrl(url)
    }
}