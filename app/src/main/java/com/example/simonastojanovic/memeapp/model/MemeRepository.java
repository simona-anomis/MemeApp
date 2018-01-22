package com.example.simonastojanovic.memeapp.model;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.simonastojanovic.memeapp.network.ApiInterface;
import com.example.simonastojanovic.memeapp.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MemeRepository {

    private final String LOG_TAG = getClass().getName();
    private ApiInterface apiInterface;
    private MutableLiveData<ArrayList<Meme>> memeResponseLiveData = new MutableLiveData<>();

    public MemeRepository() {

    }
    public LiveData<ArrayList<Meme>> getMemeListData() {
        return memeResponseLiveData;
    }

    public void getMemeList() {

        apiInterface = RetrofitClient.getClient().create(ApiInterface.class);

        Call<Response> call = apiInterface.getMemes();

        call.enqueue(new Callback<Response>() {

            @Override
            public void onResponse(Call<com.example.simonastojanovic.memeapp.model.Response> call, retrofit2.Response<com.example.simonastojanovic.memeapp.model.Response> response) {
                Data memes = response.body().getData();

                List<MemesItem> memeList = memes.getMemes();

                ArrayList<Meme> memeArrayList = new ArrayList<>();

                for (MemesItem meme : memeList) {
                    memeArrayList.add(new Meme(meme.getUrl()));
                }

                memeResponseLiveData.setValue(memeArrayList);
            }

            @Override
            public void onFailure(Call<com.example.simonastojanovic.memeapp.model.Response> call, Throwable t) {
                Log.e(LOG_TAG, "Request failed");
            }
        });
    }


}
