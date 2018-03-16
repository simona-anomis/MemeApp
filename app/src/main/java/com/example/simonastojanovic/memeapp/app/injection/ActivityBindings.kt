package com.example.simonastojanovic.memeapp.app.injection

import com.example.simonastojanovic.memeapp.memelist.view.MainActivity
import com.example.simonastojanovic.memeapp.memelist.injection.MainActivityModule

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindings {

    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun bindMainActivity(): MainActivity

}
