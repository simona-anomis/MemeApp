package com.example.simonastojanovic.memeapp.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.simonastojanovic.memeapp.model.MemeRepository;
import com.example.simonastojanovic.memeapp.model.MemesItem;

import java.util.ArrayList;

public class MemeViewModel extends ViewModel {

    private MemeRepository memeRepository;


    public MemeViewModel() {
        this.memeRepository = new MemeRepository();

    }

    public LiveData<ArrayList<MemesItem>> getMemeLiveData() {
        return memeRepository.getMemeListData();
    }

    public void getMemeList() {
        memeRepository.getMemeList();
    }
}
