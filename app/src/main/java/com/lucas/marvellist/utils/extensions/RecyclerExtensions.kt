package com.lucas.marvellist.utils.extensions

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lucas.marvellist.models.interfaces.IScrollToBottomListener

fun RecyclerView.setScrollToBottomListener(
    visibleItemsBeforeLoadMore: Int,
    listener: IScrollToBottomListener
) {
    this.setOnScrollChangeListener { _, _, _, _, _ ->
        adapter?.let {
            adapter?.itemCount?.let { totalItemCount ->
                val lastVisibleItem =
                    (layoutManager as LinearLayoutManager).findLastVisibleItemPosition()

                if (totalItemCount <= (lastVisibleItem + visibleItemsBeforeLoadMore)) {
                    listener.bottomReached();
                }
            }
        }
    }
}
