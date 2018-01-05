package com.example.simonastojanovic.memeapp.network;


import com.example.simonastojanovic.memeapp.model.Response;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("get_memes")
    Call<Response> getMemes();

}
