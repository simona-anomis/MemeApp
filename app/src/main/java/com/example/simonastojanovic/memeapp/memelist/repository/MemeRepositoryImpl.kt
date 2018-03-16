package com.example.simonastojanovic.memeapp.memelist.repository

import com.example.simonastojanovic.memeapp.app.model.Meme
import com.example.simonastojanovic.memeapp.app.network.model.Response
import com.example.simonastojanovic.memeapp.app.network.ApiInterface
import com.example.simonastojanovic.memeapp.app.network.model.MemesItem
import io.reactivex.Observable
import java.util.ArrayList
import javax.inject.Inject

class MemeRepositoryImpl @Inject constructor(
        private val apiInterface: ApiInterface
) : MemeRepository {

    override fun getMemes(): Observable<List<Meme>> =
            apiInterface.getMemes()
                    .map {
                        val memeList = it.data!!.memes

                        val memes = arrayListOf<Meme>()

                        memeList.forEach {
                            memes.add(Meme(it.url))
                        }
                        return@map memes
                    }

}
