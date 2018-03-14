package com.example.simonastojanovic.memeapp.model

import com.google.gson.annotations.SerializedName

class Data {

    @SerializedName("memes")
    lateinit var memes: List<MemesItem>

    override fun toString(): String {
        return "Data{" +
                "memes = '" + memes + "\'" +
                "}"
    }
}
