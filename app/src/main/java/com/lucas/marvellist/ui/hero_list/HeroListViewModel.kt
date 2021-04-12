package com.lucas.marvellist.ui.hero_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucas.marvellist.models.Hero
import com.lucas.marvellist.models.interfaces.IHeroListViewModel
import com.lucas.marvellist.models.interfaces.IListViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HeroListViewModel : ViewModel(), IHeroListViewModel, IListViewModel {

    override val heroList = MutableLiveData<List<Hero>>()
    override val isLoadingScreen = MutableLiveData<Boolean>()

    override fun loadScreenIfNeeded() {
        if (needsToLoadScreen()){
            viewModelScope.launch {
                heroList.value = listOf(
                    Hero( resourceURI = "https://dam.smashmexico.com.mx/wp-content/uploads/2020/01/teoria-thanos-titere.jpg",
                        name = "Thanos", description = "Using the power of the Infinity Stones, Thanos has made horrible things like kill half universe and more stuff like this."),
                    Hero( resourceURI = "https://i1.wp.com/hipertextual.com/wp-content/uploads/2020/09/hipertextual-fortnite-rinde-homenaje-chadwick-boseman-con-impresionante-estatua-black-panther-2020149363.jpg?resize=1200%2C900&ssl=1",
                        name = "Black Panther", description = "As the king of the African nation of Wakanda and more and more and more and more description."),
                )
            }
        }
    }

    override fun needsToLoadScreen(): Boolean {
        val isNull = heroList.value == null
        val isEmpty = heroList.value?.isEmpty() == true

        return isNull || isEmpty
    }

}