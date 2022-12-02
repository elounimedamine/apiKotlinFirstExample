package com.example.myapplication

import com.google.gson.annotations.SerializedName

class Post(val title:String,val body:String, @SerializedName("userId") val user_id:Int) {
}