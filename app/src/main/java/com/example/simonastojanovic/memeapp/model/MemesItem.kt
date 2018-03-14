package com.example.simonastojanovic.memeapp.model

import com.google.gson.annotations.SerializedName

class MemesItem {

    @SerializedName("name")
    var name: String? = null

    @SerializedName("width")
    var width: Int = 0

    @SerializedName("id")
    var id: String? = null

    @SerializedName("url")
    var url: String? = null

    @SerializedName("height")
    var height: Int = 0

    override fun toString(): String {
        return "MemesItem{" +
                "name = '" + name + "\'" +
                ",width = '" + width + '\''.toString() +
                ",id = '" + id + '\''.toString() +
                ",url = '" + url + '\''.toString() +
                ",height = '" + height + '\''.toString() +
                "}"
    }
}