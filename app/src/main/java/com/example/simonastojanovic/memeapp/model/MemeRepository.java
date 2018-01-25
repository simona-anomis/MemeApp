package com.example.simonastojanovic.memeapp.model;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.simonastojanovic.memeapp.network.ApiInterface;
import com.example.simonastojanovic.memeapp.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MemeRepository {

    private final String LOG_TAG = getClass().getName();
    private ApiInterface apiInterface;
    private MutableLiveData<ArrayList<MemesItem>> memeResponseLiveData = new MutableLiveData<>();

    public MemeRepository() {
    }

    public LiveData<ArrayList<MemesItem>> getMemeListData() {
        return memeResponseLiveData;
    }

    public void getMemeList() {

        apiInterface = RetrofitClient.getClient().create(ApiInterface.class);

        Observable<Response> memes = apiInterface.getMemes().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

        memes.subscribe(new Observer<Response>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                }

                    @Override
                    public void onNext(Response response) {
                    Data memes = response.getData();

                    List<MemesItem> memeList = memes.getMemes();

                    ArrayList<MemesItem> memeArrayList = new ArrayList<>();

                    for (int i = 0; i < memeList.size(); i++) {
                        MemesItem memeItem = new MemesItem();
                        memeItem.setUrl(memeList.get(i).getUrl());
                        memeArrayList.add(memeItem);
                    }

                    memeResponseLiveData.setValue(memeArrayList);

                }

                    @Override
                    public void onError(Throwable e) {

                }

                    @Override
                    public void onComplete() {

            }
        });
    }
}
