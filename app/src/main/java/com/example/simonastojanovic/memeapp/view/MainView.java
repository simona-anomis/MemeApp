package com.example.simonastojanovic.memeapp.view;

import com.example.simonastojanovic.memeapp.model.Meme;

import java.util.ArrayList;

public interface MainView {

    void onMemesFetched(ArrayList<Meme> memes);
}
