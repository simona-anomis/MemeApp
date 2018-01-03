package com.example.simonastojanovic.memeapp;


public class Meme {

    private String imageUrl;

    public Meme(String imageUrl) {
        this.imageUrl = imageUrl;

    }

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
