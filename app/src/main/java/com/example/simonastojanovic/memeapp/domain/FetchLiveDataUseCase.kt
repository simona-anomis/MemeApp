package com.example.simonastojanovic.memeapp.domain

import android.arch.lifecycle.MutableLiveData
import com.example.simonastojanovic.memeapp.model.MemesItem
import java.util.*

interface FetchLiveDataUseCase {

//    fun getMemeLiveData(): MutableLiveData<ArrayList<MemesItem>>

    var memeLiveData: MutableLiveData<ArrayList<MemesItem>>

}
