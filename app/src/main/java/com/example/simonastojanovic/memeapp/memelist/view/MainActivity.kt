package com.example.simonastojanovic.memeapp.memelist.view

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.simonastojanovic.memeapp.R
import com.example.simonastojanovic.memeapp.app.view.BaseActivity
import com.example.simonastojanovic.memeapp.memelist.view.adapter.MemeAdapter
import com.example.simonastojanovic.memeapp.memelist.viewmodel.MemeViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var memeAdapter: MemeAdapter

    @Inject
    lateinit var memeViewModel: MemeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpRecyclerView()
        memeViewModel.getMemeApiList()
    }

    override fun provideLayout(): Int = R.layout.activity_main

    override fun provideViewModel() {
        memeViewModel.memeLiveData.observe(this, Observer { it?.let { memeAdapter.addResults(it) } })
    }

    private fun setUpRecyclerView() {
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = memeAdapter
    }

}
