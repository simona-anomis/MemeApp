package com.example.simonastojanovic.memeapp.memelist.widget

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.simonastojanovic.memeapp.app.model.Meme
import com.example.simonastojanovic.memeapp.memelist.view.adapter.MemeAdapter
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.widget_meme_list.*
import javax.inject.Inject

class MemeListWidgetImpl @Inject constructor(
        private val memeAdapter: MemeAdapter,
        private val layoutManager: RecyclerView.LayoutManager
) : MemeListWidget,
        LayoutContainer {

    override lateinit var containerView: View

    override fun init(view: View) {
        containerView = view
        recycler_view.layoutManager = layoutManager
        recycler_view.adapter = memeAdapter
    }

    override fun addResults(memeList: List<Meme>) {
        memeAdapter.addResults(memeList)
    }

}