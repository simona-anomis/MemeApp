package com.example.simonastojanovic.memeapp.injection;

import android.app.Activity;

import com.example.simonastojanovic.memeapp.view.MainActivity;
import com.example.simonastojanovic.memeapp.view.MainActivityComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module
public abstract class ActivityBuilder {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindMainActivity(MainActivityComponent.Builder builder);

}
