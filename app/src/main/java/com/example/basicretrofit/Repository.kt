package com.example.basicretrofit

class Repository {
    private val apiServices = RetrofitBuilder.getApi

    suspend fun getPosts(): List<Post> = apiServices.getPost()
}