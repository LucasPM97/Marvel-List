package com.lucas.marvellist.ui.events

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lucas.marvellist.R
import com.lucas.marvellist.databinding.EventItemBinding
import com.lucas.marvellist.models.Event
import com.lucas.marvellist.ui.components.adapters.ComicListAdapter
import com.lucas.marvellist.ui.events.compose.EventItem
import com.lucas.marvellist.ui.hero_list.compose.HeroListScreen

class EventsAdapter(
    private var events: List<Event>
) : RecyclerView.Adapter<EventsAdapter.ViewHolder>() {

    private var collapsedItemPosition: Int = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = EventItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(
            events[position],
            isCollapsed = position.equals(collapsedItemPosition)
        ) { newCollpasedPosition: Int -> setCollapsedItemPosition(newCollpasedPosition) }

    private fun setCollapsedItemPosition(position: Int) {
        val oldPosition = collapsedItemPosition
        collapsedItemPosition = position
        notifyItemChanged(position)
        if (oldPosition != -1) {
            notifyItemChanged(oldPosition)
        }
    }

    override fun getItemCount(): Int = events.size

    fun updateList(values: List<Event>) {
        events = values
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: EventItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            eventData: Event?,
            isCollapsed: Boolean,
            updateCollapsedItemPosition: (Int) -> Unit
        ) {
            binding.root.apply {
                setContent {
                    EventItem(
                        eventData!!,
                        Modifier
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}
