package com.pucpr.composestates

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pucpr.composestates.ui.theme.ComposeStatesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val countViewModel = viewModel<CountViewModel>()
            ComposeStatesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ){
                        var count = countViewModel.count
                        SimpleButton(count){
                            countViewModel.setCountValue(it+1)
                        }
                    }

                }
            }
        }
    }
}


@Composable
fun SimpleButton(count:Int,updateCount:(Int)->Unit){
    val context = LocalContext.current
    //var count = remember{mutableStateOf(0)}

    Button(onClick = {
        updateCount(count)
        Toast.makeText(context,"Count is $count",Toast.LENGTH_SHORT).show()
    }) {
        Text(text = "Count $count")
    }
}