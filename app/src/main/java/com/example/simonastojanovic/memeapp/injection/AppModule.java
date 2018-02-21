package com.example.simonastojanovic.memeapp.injection;

import android.app.Application;
import android.content.Context;

import com.example.simonastojanovic.memeapp.view.MainActivityComponent;

import dagger.Module;
import dagger.Provides;

@Module(subcomponents = {
        MainActivityComponent.class})

public class AppModule {

    @Provides
    Context provideContext(Application application) {
        return application;
    }
}
