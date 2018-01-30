package com.example.simonastojanovic.memeapp.model;


import com.example.simonastojanovic.memeapp.network.ApiInterface;
import com.example.simonastojanovic.memeapp.network.RetrofitClient;

import io.reactivex.Observable;

public class MemeRepository {

    private ApiInterface apiInterface;

    public MemeRepository() {
    }

    public Observable<Response> getMemeList() {

        apiInterface = RetrofitClient.getClient()
                .create(ApiInterface.class);

        Observable<Response> memes = apiInterface.getMemes();

        return memes;

    }
}
