package com.example.simonastojanovic.memeapp.domain

import android.arch.lifecycle.MutableLiveData

import com.example.simonastojanovic.memeapp.model.Data
import com.example.simonastojanovic.memeapp.model.MemeRepository
import com.example.simonastojanovic.memeapp.model.MemesItem
import com.example.simonastojanovic.memeapp.model.Response

import java.util.ArrayList

import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class FetchMemeUseCaseImpl : FetchMemeUseCase {

    private val memeRepository = MemeRepository()

    override fun execute(memeResponseLiveData: MutableLiveData<ArrayList<MemesItem>>) {
        memeRepository.memeList
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<Response> {
                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onNext(response: Response) {
                        val memes = response.data

                        val memeList = memes!!.memes

                        val memeArrayList = ArrayList<MemesItem>()

                        for (i in memeList.indices) {
                            val memeItem = MemesItem()
                            memeItem.url = memeList[i].url
                            memeArrayList.add(memeItem)
                        }

                        memeResponseLiveData.value = memeArrayList

                    }

                    override fun onError(e: Throwable) {

                    }

                    override fun onComplete() {

                    }
                })
    }
}
