package com.example.simonastojanovic.memeapp.memelist.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.simonastojanovic.memeapp.memelist.domain.FetchMemeUseCase
import javax.inject.Inject

class MemeViewModelFactory @Inject constructor(
        private val fetchMemeUseCase: FetchMemeUseCase
) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MemeViewModel(fetchMemeUseCase) as T
    }

}