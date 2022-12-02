package com.example.myapplication
import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.items

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    //lateinit var album:Deferred<Album>
   lateinit var album:Album
   lateinit var post:Post
    lateinit var albums:List<Album>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val albumApi = RetrofitHelper.getInstance().create(ApiAlbum::class.java)


            runBlocking<Unit> {
                // album= async { albumApi.getAlbum().body()!!}.await()
                //albums= async { albumApi.getAlbums().body()!!}.await()
                post= async { albumApi.addPost(Post("titleuuuuuuuuuuuu","body",3)).body()!!}.await()


            }
            // Checking the results



        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting(post)
                }
            }
        }
    }


}

@Composable
fun Greeting(post:Post) {
    Column() {
        Text(post.title)
        Text("${post.user_id}")

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        //Greeting("Android")
    }
}