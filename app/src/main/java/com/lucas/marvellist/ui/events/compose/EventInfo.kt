package com.lucas.marvellist.ui.events.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lucas.marvellist.R
import com.lucas.marvellist.models.Event

@Composable
fun EventInfo(event: Event, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = event.title,
            color = colorResource(R.color.black),
            fontSize = 24.sp,
            fontFamily = FontFamily.SansSerif
        )
        Text(
            text = event.getStartDate(),
            color = colorResource(R.color.description_text_color),
            fontSize = 14.sp,
            modifier = Modifier
                .padding(top = 9.dp)
        )
        Text(
            text = event.getStartDate(),
            color = colorResource(R.color.description_text_color),
            fontSize = 14.sp
        )
    }
}

