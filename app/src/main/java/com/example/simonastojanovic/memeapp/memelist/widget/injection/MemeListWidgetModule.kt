package com.example.simonastojanovic.memeapp.memelist.widget.injection

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.simonastojanovic.memeapp.memelist.view.adapter.MemeAdapter
import com.example.simonastojanovic.memeapp.memelist.widget.MemeListWidget
import com.example.simonastojanovic.memeapp.memelist.widget.MemeListWidgetImpl
import dagger.Module
import dagger.Provides

@Module
class MemeListWidgetModule {

    @Provides
    fun provideMemeListWidget(memeListWidget: MemeListWidgetImpl): MemeListWidget {
        return memeListWidget
    }

    @Provides
    fun provideMemeAdapter(context: Context): MemeAdapter {
        return MemeAdapter(context)
    }

    @Provides
    fun provideLayoutManager(context: Context): RecyclerView.LayoutManager {
        return LinearLayoutManager(context)
    }

}