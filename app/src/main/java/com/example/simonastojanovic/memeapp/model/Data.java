package com.example.simonastojanovic.memeapp.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("memes")
	private List<MemesItem> memes;

	public void setMemes(List<MemesItem> memes){
		this.memes = memes;
	}

	public List<MemesItem> getMemes(){
		return memes;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"memes = '" + memes + '\'' + 
			"}";
		}
}
