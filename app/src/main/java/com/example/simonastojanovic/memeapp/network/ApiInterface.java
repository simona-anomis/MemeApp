package com.example.simonastojanovic.memeapp.network;


import com.example.simonastojanovic.memeapp.model.Response;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("get_memes")
    Observable<Response> getMemes();

}
