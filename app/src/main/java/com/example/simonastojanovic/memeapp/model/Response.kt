package com.example.simonastojanovic.memeapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Response {

    @SerializedName("data")
    var data: Data? = null

    @SerializedName("success")
    @Expose
    var isSuccess: Boolean = false

    override fun toString(): String {
        return "Response{" +
                "data = '" + data + '\''.toString() +
                ",success = '" + isSuccess + '\''.toString() +
                "}"
    }
}