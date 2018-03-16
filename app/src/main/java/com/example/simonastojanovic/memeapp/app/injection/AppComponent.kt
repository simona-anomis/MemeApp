package com.example.simonastojanovic.memeapp.app.injection

import android.app.Application

import com.example.simonastojanovic.memeapp.MemeApp

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

@Component(modules = arrayOf(AndroidInjectionModule::class, AppModule::class, ActivityBindings::class))
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: MemeApp)
}
