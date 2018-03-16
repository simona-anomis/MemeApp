package com.example.simonastojanovic.memeapp.memelist.view

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.View
import com.example.simonastojanovic.memeapp.R
import com.example.simonastojanovic.memeapp.app.view.BaseActivity
import com.example.simonastojanovic.memeapp.memelist.viewmodel.MemeViewModel
import com.example.simonastojanovic.memeapp.memelist.widget.MemeListWidget
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var memeListWidget: MemeListWidget

    @Inject
    lateinit var memeViewModel: MemeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        memeViewModel.getMemeApiList()
    }

    override fun provideLayout(): Int = R.layout.activity_main

    override fun provideViewModel() {
        memeViewModel.memeLiveData.observe(this, Observer { it?.let { memeListWidget.addResults(it) } })
    }

    override fun initWidgets(view: View) {
        memeListWidget.init(view)
    }

}
