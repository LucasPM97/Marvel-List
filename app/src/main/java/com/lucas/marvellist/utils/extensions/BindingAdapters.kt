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

//ProgressBar
@BindingAdapter("isLoading")
fun setProgressBarVisibility(view: ProgressBar, isLoading: Boolean) {
    view.visibility = if (isLoading) View.VISIBLE else View.GONE
}