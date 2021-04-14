package com.lucas.marvellist.utils.extensions

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter

//ImageView
@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String?) {
    url?.let {
        view.loadFromUrl(url)
    }
}

//Generic View
@BindingAdapter("isVisible")
fun setVisibility(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}