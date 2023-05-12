package com.pucpr.movieapp.composable

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.pucpr.movieapp.model.TvShow

@Composable
fun TvShowTextsColumn(tvShow: TvShow) {
    Column() {
        Text(text = tvShow.name,
            style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = tvShow.overview,
            style = MaterialTheme.typography.body1,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TvShowYearColumn(tvShow)
            TvShowRatingColumn(tvShow)
        }


    }
}