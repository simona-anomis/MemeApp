package com.example.simonastojanovic.memeapp.memelist.injection

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import com.example.simonastojanovic.memeapp.memelist.domain.FetchMemeUseCase
import com.example.simonastojanovic.memeapp.memelist.domain.FetchMemeUseCaseImpl
import com.example.simonastojanovic.memeapp.app.network.model.MemesItem
import com.example.simonastojanovic.memeapp.memelist.view.MainActivity
import com.example.simonastojanovic.memeapp.memelist.view.adapter.MemeAdapter
import com.example.simonastojanovic.memeapp.memelist.viewmodel.MemeViewModel
import com.example.simonastojanovic.memeapp.memelist.viewmodel.MemeViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun provideMemeViewModel(mainActivity: MainActivity, memeViewModelFactory: MemeViewModelFactory): MemeViewModel {
        return ViewModelProviders.of(mainActivity, memeViewModelFactory).get(MemeViewModel::class.java)
    }

    @Provides
    fun provideMemeAdapter(context: Context): MemeAdapter {
        return MemeAdapter(context)
    }

    @Provides
    fun provideMutableLiveDataMemes(): MutableLiveData<List<MemesItem>> {
        return MutableLiveData()
    }

    @Provides
    fun provideFetchMemeUseCase(fetchMemeUseCase: FetchMemeUseCaseImpl): FetchMemeUseCase {
        return fetchMemeUseCase
    }

}
