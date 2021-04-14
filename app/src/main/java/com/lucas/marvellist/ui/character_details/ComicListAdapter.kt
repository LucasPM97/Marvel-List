package com.lucas.marvellist.ui.character_details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.lucas.marvellist.databinding.ComicItemBinding
import com.lucas.marvellist.databinding.HeroItemBinding
import com.lucas.marvellist.models.Comic
import com.lucas.marvellist.models.Hero

class ComicListAdapter(
    private var comics: List<Comic>
) : RecyclerView.Adapter<ComicListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ComicItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(comics[position])

    override fun getItemCount(): Int = comics.size

    class ViewHolder(private val binding: ComicItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(comicData: Comic) {
            binding.apply {
                comic = comicData
            }
        }
    }
}
