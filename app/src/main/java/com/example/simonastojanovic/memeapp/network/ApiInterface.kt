package com.example.simonastojanovic.memeapp.network

import com.example.simonastojanovic.memeapp.model.Response

import io.reactivex.Observable
import retrofit2.http.GET

interface ApiInterface {
    @get:GET("get_memes")
    val memes: Observable<Response>

}
