package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.*

class MainActivity : ComponentActivity() {
    lateinit var album:Deferred<Album>
    lateinit var album1:Album
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val albumApi = RetrofitHelper.getInstance().create(ApiAlbum::class.java)
            runBlocking<Unit>
            {
                album= async {
                    albumApi.getAlbum().body()!!
                }

               album1=album.await()
            }
            // Checking the results



        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting(album1)
                }
            }
        }
    }
}

@Composable
fun Greeting(album: Album) {
    Text(album.title)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        //Greeting("Android")
    }
}