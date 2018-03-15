package com.example.simonastojanovic.memeapp.view

import android.arch.lifecycle.ViewModelProviders
import android.content.Context

import com.example.simonastojanovic.memeapp.viewmodel.MemeViewModel

import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun provideMemeViewModel(mainActivity: MainActivity): MemeViewModel {
        return ViewModelProviders.of(mainActivity).get(MemeViewModel::class.java)
    }

    @Provides
    fun provideMemeAdapter(context: Context): MemeAdapter {
        return MemeAdapter(context)
    }
}
