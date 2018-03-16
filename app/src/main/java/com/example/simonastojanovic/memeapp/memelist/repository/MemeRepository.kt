package com.example.simonastojanovic.memeapp.memelist.repository

import com.example.simonastojanovic.memeapp.app.model.Meme
import io.reactivex.Observable

interface MemeRepository {

    val memeList: Observable<List<Meme>>

}
