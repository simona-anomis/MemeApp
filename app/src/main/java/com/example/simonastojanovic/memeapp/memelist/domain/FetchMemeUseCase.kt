package com.example.simonastojanovic.memeapp.memelist.domain

import android.arch.lifecycle.LiveData
import com.example.simonastojanovic.memeapp.app.model.Meme

interface FetchMemeUseCase {

    fun liveData(): LiveData<List<Meme>>

    fun execute()

}