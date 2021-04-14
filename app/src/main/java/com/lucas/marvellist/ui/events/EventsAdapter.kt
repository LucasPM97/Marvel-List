package com.lucas.marvellist.ui.events

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lucas.marvellist.databinding.EventItemBinding
import com.lucas.marvellist.models.Event

class EventsAdapter(
    private var events: List<Event>
) : RecyclerView.Adapter<EventsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = EventItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(events[position])

    override fun getItemCount(): Int = events.size

    fun updateList(values: List<Event>) {
        events = values
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: EventItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(eventData: Event) {
            binding.apply {
                event = eventData
            }
        }
    }
}
