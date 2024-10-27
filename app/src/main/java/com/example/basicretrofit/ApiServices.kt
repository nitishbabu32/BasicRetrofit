package com.example.basicretrofit

import retrofit2.http.GET

interface ApiServices {


    @GET("posts")
    suspend fun getPost():List<Post>
}