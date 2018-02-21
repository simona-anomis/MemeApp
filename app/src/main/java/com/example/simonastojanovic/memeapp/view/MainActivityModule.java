package com.example.simonastojanovic.memeapp.view;

import com.example.simonastojanovic.memeapp.viewmodel.MemeViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    @Provides
    MainActivity provideMainActivity(MainActivity mainActivity) {
        return mainActivity;
    }

    @Provides
    MemeViewModel provideMemeViewModel(){
    return new MemeViewModel();
    }
}
