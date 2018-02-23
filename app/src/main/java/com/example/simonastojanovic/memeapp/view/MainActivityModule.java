package com.example.simonastojanovic.memeapp.view;

import android.arch.lifecycle.ViewModelProviders;

import com.example.simonastojanovic.memeapp.viewmodel.MemeViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    @Provides
    MemeViewModel provideMemeViewModel(MainActivity mainActivity) {
        return ViewModelProviders.of(mainActivity).get(MemeViewModel.class);
    }
}
