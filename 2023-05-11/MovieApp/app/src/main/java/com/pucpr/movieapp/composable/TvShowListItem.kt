package com.pucpr.movieapp.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.pucpr.movieapp.model.TvShow

@Composable
fun TvShowListItem(tvShow: TvShow, selectItem:(TvShow)->Unit){
    Card(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth(),
        elevation = 10.dp,
        shape = RoundedCornerShape(corner = CornerSize(10.dp))
    ) {
        Row(modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .clickable { selectItem(tvShow) },
            verticalAlignment = Alignment.CenterVertically) {
            TvShowImage(tvShow = tvShow)
            TvShowTextsColumn(tvShow = tvShow)

        }

    }
}