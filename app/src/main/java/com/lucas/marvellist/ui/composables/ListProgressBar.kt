package com.lucas.marvellist.ui.composables

import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

@Composable
fun ListProgressBar(isLoadingLive: LiveData<Boolean>,modifier: Modifier = Modifier) {
    val isLoading by isLoadingLive.observeAsState(initial = false)

    if(isLoading) LinearProgressIndicator(modifier = modifier)
}

@Composable
@Preview
fun PreviewListProgressBar(){
    ListProgressBar(
        isLoadingLive = MutableLiveData(true),
    )
}