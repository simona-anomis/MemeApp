package com.example.simonastojanovic.memeapp.injection;

import com.example.simonastojanovic.memeapp.view.MainActivity;
import com.example.simonastojanovic.memeapp.view.MainActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindings {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity bindMainActivity();

}
