package com.lucas.marvellist.ui.events

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lucas.marvellist.R
import com.lucas.marvellist.databinding.EventItemBinding
import com.lucas.marvellist.models.Event
import com.lucas.marvellist.ui.components.adapters.ComicListAdapter

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
            binding.apply {
                collapsed = isCollapsed

                eventData?.let {
                    event = it

                    hasComics = !it.comics?.items.isNullOrEmpty()

                    imageButton.setImageResource(
                        if (isCollapsed) R.drawable.outline_expand_less_black_36 else R.drawable.outline_expand_more_black_36
                    )

                    if (isCollapsed) {
                        recyclerView.apply {
                            layoutManager = LinearLayoutManager(context)
                            adapter = ComicListAdapter(it.comics?.items ?: emptyList())
                            addItemDecoration(
                                DividerItemDecoration(
                                    context,
                                    DividerItemDecoration.VERTICAL
                                )
                            )
                        }
                    }
                    root.setOnClickListener {
                        if (!eventData.comics?.items.isNullOrEmpty()) {
                            updateCollapsedItemPosition(
                                if (isCollapsed!!) -1 else layoutPosition
                            )
                        }
                    }
                }

            }
        }
    }
}
