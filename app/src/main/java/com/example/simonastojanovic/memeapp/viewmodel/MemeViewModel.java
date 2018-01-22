package com.example.simonastojanovic.memeapp.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.simonastojanovic.memeapp.model.Meme;
import com.example.simonastojanovic.memeapp.model.MemeRepository;

import java.util.ArrayList;

public class MemeViewModel extends ViewModel {

    private MemeRepository memeRepository;


    public MemeViewModel() {
        this.memeRepository = new MemeRepository();

    }

    public LiveData<ArrayList<Meme>> getMemeLiveData() {
        return memeRepository.getMemeListData();
    }

    public void getMemeList() {
        memeRepository.getMemeList();
    }
}
