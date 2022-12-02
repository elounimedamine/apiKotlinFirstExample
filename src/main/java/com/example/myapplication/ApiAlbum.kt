package com.example.myapplication

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiAlbum {

    @GET("/albums/1")
    suspend fun getAlbum() : Response<Album>

    @GET("/albums")
    suspend fun getAlbums() : Response<List<Album>>

    @Headers("Content-Type: application/json")
    @POST("/posts")
    suspend fun addPost(@Body post:Post) : Response<Post>





    /* @GET("/albums")

    suspend fun getAlbums() : Response<List<Album>>
    @Headers("Content-Type: application/json")
    @POST("/posts")
    suspend fun addPost(@Body PostData: Post): Response<Post>
    */





}