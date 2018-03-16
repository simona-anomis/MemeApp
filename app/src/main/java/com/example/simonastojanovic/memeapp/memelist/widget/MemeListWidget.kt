package com.example.simonastojanovic.memeapp.memelist.widget

import android.view.View
import com.example.simonastojanovic.memeapp.app.model.Meme

interface MemeListWidget {

    fun init(view: View)

    fun addResults(memeList: List<Meme>)
}