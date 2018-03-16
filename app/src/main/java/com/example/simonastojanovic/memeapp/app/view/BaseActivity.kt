package com.example.simonastojanovic.memeapp.app.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import dagger.android.AndroidInjection

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(provideLayout())
        initWidgets(findViewById(android.R.id.content))
        provideViewModel()
    }

    abstract fun provideLayout(): Int

    abstract fun provideViewModel()

    abstract fun initWidgets(view : View)

}


