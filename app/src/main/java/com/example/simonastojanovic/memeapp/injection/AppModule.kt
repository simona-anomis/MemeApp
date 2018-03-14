package com.example.simonastojanovic.memeapp.injection

import android.app.Application
import android.content.Context

import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    internal fun provideContext(application: Application): Context {
        return application
    }
}
