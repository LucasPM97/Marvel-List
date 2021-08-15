package com.lucas.marvellist.ui.hero_list

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import com.lucas.marvellist.models.Character


@Composable
fun HeroList(liveCharacters: LiveData<List<Character>>, navController: NavController? = null) {

    val characters by liveCharacters.observeAsState(initial = emptyList())

    val listState = rememberLazyListState()

    // Remember a CoroutineScope to be able to launch
    val coroutineScope = rememberCoroutineScope()

    fun handleOnClick(character: Character):Unit{
        navController?.let {

            val action =
                HeroListFragmentDirections.actionNavigationHeroListToCharacterDetailsFragment(
                    character,
                    character.name!!
                )
            it.navigate(action)
        }
    }

    LazyColumn() {
        itemsIndexed(characters) { _, character ->
            HeroItem(
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
private fun PreviewHeroList() {
    val liveList = MutableLiveData<List<Character>>(
        listOf(
            Character(
                name = "Stan lee",
                description = "Description sample"
            )
        )
    )

    HeroList(liveList)
}