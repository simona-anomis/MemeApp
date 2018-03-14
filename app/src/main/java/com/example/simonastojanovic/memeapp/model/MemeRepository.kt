package com.example.simonastojanovic.memeapp.model


import com.example.simonastojanovic.memeapp.network.ApiInterface
import com.example.simonastojanovic.memeapp.network.RetrofitClient

import io.reactivex.Observable

class MemeRepository {

    lateinit var apiInterface: ApiInterface

    val memeList: Observable<Response>
        get() {

            apiInterface = RetrofitClient.client
                    .create(ApiInterface::class.java)

            return apiInterface.memes

        }
}
