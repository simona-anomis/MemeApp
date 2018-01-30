package com.example.simonastojanovic.memeapp.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.simonastojanovic.memeapp.domain.FetchLiveDataUseCase;
import com.example.simonastojanovic.memeapp.domain.FetchLiveDataUseCaseImpl;
import com.example.simonastojanovic.memeapp.domain.FetchMemeUseCase;
import com.example.simonastojanovic.memeapp.domain.FetchMemeUseCaseImpl;
import com.example.simonastojanovic.memeapp.model.MemesItem;

import java.util.ArrayList;

public class MemeViewModel extends ViewModel {

    private FetchLiveDataUseCase fetchLiveDataUseCase;
    private FetchMemeUseCase fetchMemeUseCase;


    public MemeViewModel() {
        this.fetchLiveDataUseCase = new FetchLiveDataUseCaseImpl();
        this.fetchMemeUseCase = new FetchMemeUseCaseImpl();
    }

    public MutableLiveData<ArrayList<MemesItem>> getMemeLiveData() {
        return fetchLiveDataUseCase.getLiveData();
    }



    public void getMemeList() {
        fetchMemeUseCase.execute(getMemeLiveData());
    }

}
