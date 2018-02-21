package com.example.simonastojanovic.memeapp.view;


import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent(modules = {MainActivityModule.class})

public interface MainActivityComponent extends AndroidInjector<MainActivity>{
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity>{}
}
