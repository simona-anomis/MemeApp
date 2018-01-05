package com.example.simonastojanovic.memeapp.presenter;

import android.util.Log;

import com.example.simonastojanovic.memeapp.model.Data;
import com.example.simonastojanovic.memeapp.model.Meme;
import com.example.simonastojanovic.memeapp.model.MemesItem;
import com.example.simonastojanovic.memeapp.network.ApiInterface;
import com.example.simonastojanovic.memeapp.network.RetrofitClient;
import com.example.simonastojanovic.memeapp.view.MainView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MemePresenterImpl implements MemePresenter {

    private final MainView view;
    private ApiInterface apiInterface;
    private final String LOG_TAG = getClass().getName();

    public MemePresenterImpl(MainView view) {
        this.view = view;
        apiInterface = RetrofitClient.getClient().create(ApiInterface.class);
    }

    @Override
    public void fetchMemes() {

        Log.e(LOG_TAG, "Fetch Meme");


        Call< com.example.simonastojanovic.memeapp.model.Response> call = apiInterface.getMemes();

        Log.e(LOG_TAG, "Fetch Meme Call Executed");
        call.enqueue(new Callback<com.example.simonastojanovic.memeapp.model.Response>() {
            @Override
            public void onResponse(Call<com.example.simonastojanovic.memeapp.model.Response> call, Response<com.example.simonastojanovic.memeapp.model.Response> response) {
                Log.e(LOG_TAG, "On Response");

                Data memes = response.body().getData();

                List<MemesItem> memeList = memes.getMemes();

                ArrayList<Meme> memeArrayList = new ArrayList<>();

                for(MemesItem meme: memeList) {
                    memeArrayList.add(new Meme(meme.getUrl()));
                }

                view.onMemesFetched(memeArrayList);
            }

            @Override
            public void onFailure(Call<com.example.simonastojanovic.memeapp.model.Response> call, Throwable t) {
                Log.e(LOG_TAG, "Request failed");

            }
        });
    }

}
