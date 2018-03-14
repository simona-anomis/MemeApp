package com.example.simonastojanovic.memeapp.injection

import com.example.simonastojanovic.memeapp.view.MainActivity
import com.example.simonastojanovic.memeapp.view.MainActivityModule

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindings {

    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun bindMainActivity(): MainActivity

}
