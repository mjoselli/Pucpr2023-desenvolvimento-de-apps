package com.pucpr.movieapp.composable

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.pucpr.movieapp.model.TvShow
import com.pucpr.movieapp.model.TvShowList

@Composable
fun TvShowsList(selectItem:(TvShow)->Unit) {
    val tvShows = remember{ TvShowList.tvShows}
    LazyColumn(){
        items(
            count = tvShows.size,
            itemContent = {
                TvShowListItem(tvShow = tvShows[it],selectItem)
            }
        )
    }
}