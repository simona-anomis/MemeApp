package com.example.simonastojanovic.memeapp.view

import android.arch.lifecycle.ViewModelProviders

import com.example.simonastojanovic.memeapp.viewmodel.MemeViewModel

import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun provideMemeViewModel(mainActivity: MainActivity): MemeViewModel {
        return ViewModelProviders.of(mainActivity).get(MemeViewModel::class.java)
    }
}
