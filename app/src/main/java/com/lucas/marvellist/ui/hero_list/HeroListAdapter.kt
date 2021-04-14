package com.lucas.marvellist.ui.hero_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.lucas.marvellist.databinding.HeroItemBinding
import com.lucas.marvellist.models.Character

class HeroListAdapter(
    private var heroes: List<Character>
) : RecyclerView.Adapter<HeroListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = HeroItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(heroes[position])

    override fun getItemCount(): Int = heroes.size

    fun updateList(values: List<Character>) {
        heroes = values
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: HeroItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(heroData: Character) {
            binding.apply {
                hero = heroData
                root.setOnClickListener {
                    val action =
                        HeroListFragmentDirections.actionNavigationHeroListToCharacterDetailsFragment(
                            heroData,
                            heroData.name!!
                        )
                    it?.findNavController()?.navigate(action)
                }
            }


        }

    }

}
