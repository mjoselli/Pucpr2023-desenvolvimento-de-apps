package com.pucpr.mycompasableapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Device
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pucpr.mycompasableapp.ui.theme.MyCompasableAPPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCompasableAPPTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    //ColumnsGreeting()
                    //RowGreeting()
                    //BoxDemo()
                    //BoxImage()
                    //ColumnList()
                    LazyList()
                }
            }
        }
    }
}

@Composable
fun LazyList(){
    val context = LocalContext.current
    LazyColumn{
        items(100){
            Text(text = "User $it",
                style = MaterialTheme.typography.h3,
                modifier = Modifier
                    .clickable {
                        Toast.makeText(context,
                            "$it clicked",Toast.LENGTH_LONG
                        ).show()
                    }
            )
            Divider(color = Color.Black,
                thickness = 5.dp)
        }
    }
}
@Composable
fun ColumnList(){
    val scrollState = rememberScrollState()
    Column(modifier = Modifier
        .verticalScroll(scrollState)){
        for (i in 1..100){
            Text(text = "User $i",
                style = MaterialTheme.typography.h3)
            Divider(color = Color.Black,
                thickness = 5.dp)
        }
    }
}
@Composable
fun BoxImage(){
    val context = LocalContext.current
    Box {
        Image(
            painter = painterResource(id = R.drawable.bob_esponja),
            contentDescription = "Bob Esponja"
        )
        Text(text = "Bob Esponja",
            style = MaterialTheme.typography.h3,
            modifier = Modifier.align(Alignment.BottomStart))
        Button(onClick = {
            Toast.makeText(context,"Olá",Toast.LENGTH_LONG)
                .show()
        },
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = Color.Green,
                contentColor = Color.Black
            ),
            modifier = Modifier
                .align(Alignment.TopEnd)
        ) {
            Text(text = "Olá")
        }
        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "Text Button")
        }
        OutlinedButton(onClick = { /*TODO*/ }) {
            Text(text = "Outline Button")
        }
        IconButton(onClick = { /*TODO*/ },
        modifier = Modifier
            .align(Alignment.Center)) {
            Icon(Icons.Filled.Refresh,
                contentDescription = "Refreash")
        }
    }
}

@Composable
fun BoxDemo(){
    Box(modifier = Modifier
        .background(Color.Black)
        .size(200.dp, 200.dp)){
        Box(modifier = Modifier
            .background(Color.Red)
            .size(125.dp, 200.dp)
            .align(Alignment.TopCenter)){

        }
        Text(text = "Mark",
        modifier = Modifier
            .background(Color.LightGray)
            .size(40.dp, 40.dp)
            .align(Alignment.BottomEnd))
    }
}

@Composable
fun RowGreeting(){
    Row(
        modifier = Modifier
            .background(Color.Red),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ){
        Greeting("Android")
        Greeting("Mark")
        Greeting("Puc")
        Greeting("Android")
        Greeting("Mark")
        Greeting("Puc")
    }
}
@Composable
fun ColumnsGreeting(){
    Column(
        modifier = Modifier
        .background(Color.Red),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Greeting("Android")
        Greeting("Mark")
        Greeting("Puc")
        Greeting("Android")
        Greeting("Mark")
        Greeting("Puc")
    }
}
@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        fontSize = 32.sp,
        color = Color.Magenta,
        modifier = Modifier
            .background(Color.Blue)
            .border(2.dp, color = Color.Black)
            .padding(10.dp)
            .fillMaxWidth(0.5f)
    )
}

@Preview(showBackground = true, device = Devices.PIXEL_3A)
@Composable
fun DefaultPreview() {
    MyCompasableAPPTheme {
        LazyList()
    }
}