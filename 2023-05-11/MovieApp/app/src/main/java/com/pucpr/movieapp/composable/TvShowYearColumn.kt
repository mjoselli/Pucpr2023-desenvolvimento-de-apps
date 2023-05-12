package com.pucpr.movieapp.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.pucpr.movieapp.model.TvShow

@Composable
fun TvShowYearColumn(tvShow: TvShow){
    Column() {
        Text(text = "Year:",
            style = MaterialTheme.typography.body2)
        Text(text = tvShow.year.toString(),
            style = MaterialTheme.typography.h5)
    }
}