package com.example.simonastojanovic.memeapp.memelist.view.adapter


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.simonastojanovic.memeapp.R
import com.example.simonastojanovic.memeapp.app.model.Meme
import com.example.simonastojanovic.memeapp.memelist.view.adapter.viewholder.MemeAdapterViewHolder
import java.util.*

class MemeAdapter(private val context: Context) : RecyclerView.Adapter<MemeAdapterViewHolder>() {

    private val memeList: ArrayList<Meme> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemeAdapterViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_view, parent, false)
        view.isFocusable = true
        return MemeAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: MemeAdapterViewHolder, position: Int) {
        val meme = memeList[position]
        holder.showImage(meme.url)
    }

    override fun getItemCount(): Int {
        return memeList.size
    }

    internal fun addResults(results: List<Meme>) {
        memeList.addAll(results)
        notifyDataSetChanged()
    }

}
