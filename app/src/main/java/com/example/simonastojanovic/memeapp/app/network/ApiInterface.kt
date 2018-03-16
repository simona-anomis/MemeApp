package com.example.simonastojanovic.memeapp.app.network

import com.example.simonastojanovic.memeapp.app.network.model.Response

import io.reactivex.Observable
import retrofit2.http.GET

interface ApiInterface {

    @GET("get_memes")
    fun getMemes(): Observable<Response>

}
