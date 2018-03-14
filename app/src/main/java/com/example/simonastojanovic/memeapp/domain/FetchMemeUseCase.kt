package com.example.simonastojanovic.memeapp.domain

import android.arch.lifecycle.MutableLiveData
import com.example.simonastojanovic.memeapp.model.MemesItem
import java.util.*

interface FetchMemeUseCase {

    fun execute(memeResponseLiveData: MutableLiveData<ArrayList<MemesItem>>)

}