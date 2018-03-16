package com.example.simonastojanovic.memeapp.app.injection

import android.app.Application
import android.content.Context
import com.example.simonastojanovic.memeapp.app.network.injection.NetworkModule

import dagger.Module
import dagger.Provides

@Module(includes = [NetworkModule::class])
class AppModule {

    @Provides
    internal fun provideContext(application: Application): Context {
        return application
    }
}
