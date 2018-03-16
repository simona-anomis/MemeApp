package com.example.simonastojanovic.memeapp.memelist.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.example.simonastojanovic.memeapp.app.model.Meme
import com.example.simonastojanovic.memeapp.memelist.domain.FetchMemeUseCase

class MemeViewModel constructor(
        private val fetchMemeUseCase: FetchMemeUseCase
) : ViewModel() {

    val memeLiveData: LiveData<List<Meme>> = fetchMemeUseCase.liveData()

    fun getMemeApiList() {
        fetchMemeUseCase.execute()
    }
}
