package com.example.simonastojanovic.memeapp.domain;

import android.arch.lifecycle.MutableLiveData;

import com.example.simonastojanovic.memeapp.model.MemesItem;

import java.util.ArrayList;

public interface FetchMemeUseCase {

    void execute(MutableLiveData<ArrayList<MemesItem>> memeResponseLiveData);

}
