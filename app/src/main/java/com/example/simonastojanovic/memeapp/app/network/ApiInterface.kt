package com.example.simonastojanovic.memeapp.app.network

import com.example.simonastojanovic.memeapp.app.network.model.Response

import io.reactivex.Observable
import retrofit2.http.GET

interface ApiInterface {

    @get:GET("get_memes")
    val memes: Observable<Response>

}
