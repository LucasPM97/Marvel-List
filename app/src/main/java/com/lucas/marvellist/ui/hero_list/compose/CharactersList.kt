package com.lucas.marvellist.ui.hero_list.compose

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import com.lucas.marvellist.models.Character
import com.lucas.marvellist.ui.hero_list.HeroListFragmentDirections


@Composable
fun CharactersList(
    liveCharacters: LiveData<List<Character>>,
    onBottomReached: (() -> Unit)?,
    navController: NavController? = null,
    modifier: Modifier = Modifier
) {

    val characters by liveCharacters.observeAsState(initial = emptyList())

    fun handleOnClick(character: Character): Unit {
        navController?.let {

            val action =
                HeroListFragmentDirections.actionNavigationHeroListToCharacterDetailsFragment(
                    character,
                    character.name!!
                )
            it.navigate(action)
        }
    }

    LazyColumn(modifier = modifier) {
        itemsIndexed(characters) { index, character ->
            if (index == characters.lastIndex) {
                onBottomReached?.let {
                    it()
                }
            }

            CharacterItem(
                character,
                modifier = Modifier
                    .padding(bottom = 9.dp),
                onClick = {
                    handleOnClick(it)
                }
            )
        }
    }
}

@Composable
@Preview
private fun PreviewCharacterList() {
    val liveList = MutableLiveData<List<Character>>(
        listOf(
            Character(
                name = "Stan lee",
                description = "Description sample"
            )
        )
    )

    CharactersList(liveList, null)
}