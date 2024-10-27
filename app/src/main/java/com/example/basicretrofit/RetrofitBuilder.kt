package com.example.basicretrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    val basceURL="https://jsonplaceholder.typicode.com/"

    val getApi:ApiServices by lazy {
        Retrofit.Builder()
            .baseUrl(basceURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiServices::class.java)

    }
}