package com.example.simonastojanovic.memeapp.memelist.domain

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.example.simonastojanovic.memeapp.app.model.Meme
import com.example.simonastojanovic.memeapp.memelist.repository.MemeRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class FetchMemeUseCaseImpl @Inject constructor(
        private val memeLiveData: MutableLiveData<List<Meme>>,
        private val memeRepository: MemeRepository
) : FetchMemeUseCase {

    override fun liveData(): LiveData<List<Meme>> = memeLiveData

    override fun execute() {
        memeRepository.getMemes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess, this::onError)
    }

    private fun onSuccess(memes: List<Meme>) {
        memeLiveData.value = memes
    }

    private fun onError(throwable: Throwable) {

    }
}
