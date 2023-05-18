package com.pucpr.movieapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pucpr.movieapp.composable.TvShowDetail
import com.pucpr.movieapp.model.TvShow
import com.pucpr.movieapp.ui.theme.MovieAppTheme

class DetailActivity : ComponentActivity() {
    companion object{
        private const val TvShowId = "tvshowid"
        fun intent(context: Context,tvShow: TvShow)=
            Intent(context,DetailActivity::class.java).apply {
                putExtra(TvShowId,tvShow)
            }
    }

    private val tvShow : TvShow by lazy {
        intent?.getSerializableExtra(TvShowId) as TvShow
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TvShowDetail(tvShow = tvShow)
                }
            }
        }
    }
}