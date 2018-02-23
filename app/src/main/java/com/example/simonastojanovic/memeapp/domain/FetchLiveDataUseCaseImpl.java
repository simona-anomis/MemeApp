package com.example.simonastojanovic.memeapp.domain;

import android.arch.lifecycle.MutableLiveData;

import com.example.simonastojanovic.memeapp.model.MemesItem;

import java.util.ArrayList;

public class FetchLiveDataUseCaseImpl implements FetchLiveDataUseCase{

    private MutableLiveData<ArrayList<MemesItem>> memeLiveData = new MutableLiveData<>();

    @Override
    public MutableLiveData<ArrayList<MemesItem>> getMemeLiveData() {
        return memeLiveData;
    }
}
