package com.lucas.marvellist.utils.extensions

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.CornerFamily


//ShapeableImageView
@BindingAdapter(
    value = arrayOf(
        "top_left_corner_radius",
        "top_right_corner_radius",
        "bottom_left_corner_radius",
        "bottom_right_corner_radius"
    ),
    requireAll = false
)
fun setCornersRadius(
    view: ShapeableImageView,
    topLeftCorner: Float?,
    topRightCorner: Float?,
    bottomLeftCorner: Float?,
    bottomRightCorner: Float?
) {
    view.shapeAppearanceModel =
        view.shapeAppearanceModel
            .toBuilder().apply {
                if (topLeftCorner != null && topLeftCorner != 0f) setTopLeftCorner(
                    CornerFamily.ROUNDED,
                    topLeftCorner
                )

                if (topRightCorner != null && topRightCorner != 0f) setTopRightCorner(
                    CornerFamily.ROUNDED,
                    topRightCorner
                )

                if (bottomLeftCorner != null && bottomLeftCorner != 0f) setBottomLeftCorner(
                    CornerFamily.ROUNDED,
                    bottomLeftCorner
                )

                if (bottomRightCorner != null && bottomRightCorner != 0f) setBottomRightCorner(
                    CornerFamily.ROUNDED,
                    bottomRightCorner
                )
            }.build()
}

//ImageView
@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String?) {
    url?.let {
        view.loadFromUrl(url)
    }
}

//Generic View
@BindingAdapter("isVisible")
fun setVisibility(view: View, visible: Boolean? = false) {
    view.visibility = if (visible != null && visible) View.VISIBLE else View.GONE
}