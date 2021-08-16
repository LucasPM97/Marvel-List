package com.lucas.marvellist.ui.hero_list.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lucas.marvellist.ui.composables.ListProgressBar
import com.lucas.marvellist.ui.hero_list.HeroListViewModel

@Composable
fun HeroListScreen(viewModel: HeroListViewModel, navController: NavController?) {
    Column {
        ListProgressBar(
            isLoadingLive = viewModel.isLoading,
            modifier = Modifier.fillMaxWidth()
        )
        CharactersList(
            viewModel.heroList,
            onBottomReached = {
                viewModel.loadMoreItems()
            },
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp)
                .padding(top = 10.dp),
            navController
        )
    }
}