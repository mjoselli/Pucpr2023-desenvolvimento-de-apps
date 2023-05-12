package com.pucpr.movieapp.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.pucpr.movieapp.model.TvShow

@Composable
fun TvShowRatingColumn(tvShow: TvShow){
    Column() {
        Text(text = "Rating:",
            style = MaterialTheme.typography.body2)
        Text(text = tvShow.rating.toString(),
            style = MaterialTheme.typography.h5)
    }
}