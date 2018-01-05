package com.example.simonastojanovic.memeapp.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.simonastojanovic.memeapp.model.MemesItem;
import com.example.simonastojanovic.memeapp.network.ApiInterface;

import java.util.List;

public class MemeViewModel extends ViewModel {

    private LiveData<List<MemesItem>> memesList;
    private ApiInterface apiInterface;
    private final String LOG_TAG = getClass().getName();




}
