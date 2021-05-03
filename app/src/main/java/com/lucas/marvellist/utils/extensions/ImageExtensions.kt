package com.lucas.marvellist.utils.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide


fun ImageView.loadFromUrl(url:String) {
    Glide.with(context).load(url)
        .into(this)
}