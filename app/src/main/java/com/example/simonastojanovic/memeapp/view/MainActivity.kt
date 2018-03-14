package com.example.simonastojanovic.memeapp.view

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.simonastojanovic.memeapp.R
import com.example.simonastojanovic.memeapp.model.MemesItem
import com.example.simonastojanovic.memeapp.viewmodel.MemeViewModel
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    lateinit var memeAdapter: MemeAdapter

    @Inject
    lateinit var memeViewModel: MemeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRecyclerView()
        observeViewModel()
        memeViewModel.getMemeApiList()
    }

    private fun observeViewModel() {
        memeViewModel.memeLiveData.observe(this, Observer { memes: ArrayList<MemesItem>? ->
            if (memes != null) {
                memeAdapter.addResults(memes)
            }
        })
    }


    private fun setUpRecyclerView() {
        recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        memeAdapter = MemeAdapter(this)
        recycler_view.adapter = memeAdapter
    }

}
