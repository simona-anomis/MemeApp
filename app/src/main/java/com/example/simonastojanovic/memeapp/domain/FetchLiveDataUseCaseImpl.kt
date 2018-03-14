package com.example.simonastojanovic.memeapp.domain

import android.arch.lifecycle.MutableLiveData
import com.example.simonastojanovic.memeapp.model.MemesItem
import java.util.*


class FetchLiveDataUseCaseImpl : FetchLiveDataUseCase {

//    override fun getMemeLiveData(): MutableLiveData<ArrayList<MemesItem>> = memeLiveData

    override var memeLiveData = MutableLiveData<ArrayList<MemesItem>>()

}
