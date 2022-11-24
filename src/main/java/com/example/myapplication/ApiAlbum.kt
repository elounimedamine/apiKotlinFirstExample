package com.example.myapplication

import retrofit2.Response
import retrofit2.http.GET

interface ApiAlbum {

    @GET("/albums/1")
    suspend fun getAlbum() : Response<Album>




}