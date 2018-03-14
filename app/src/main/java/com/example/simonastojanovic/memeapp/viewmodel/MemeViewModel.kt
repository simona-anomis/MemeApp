package com.example.simonastojanovic.memeapp.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

import com.example.simonastojanovic.memeapp.domain.FetchLiveDataUseCase
import com.example.simonastojanovic.memeapp.domain.FetchLiveDataUseCaseImpl
import com.example.simonastojanovic.memeapp.domain.FetchMemeUseCase
import com.example.simonastojanovic.memeapp.domain.FetchMemeUseCaseImpl
import com.example.simonastojanovic.memeapp.model.MemesItem

import java.util.ArrayList

class MemeViewModel : ViewModel() {

    var fetchLiveDataUseCase: FetchLiveDataUseCase
    var fetchMemeUseCase: FetchMemeUseCase

    val memeLiveData: MutableLiveData<ArrayList<MemesItem>>
        get() = fetchLiveDataUseCase.memeLiveData

    init {
        this.fetchLiveDataUseCase = FetchLiveDataUseCaseImpl()
        this.fetchMemeUseCase = FetchMemeUseCaseImpl()
    }

    fun getMemeApiList() {
        fetchMemeUseCase.execute(memeLiveData)
    }
}
