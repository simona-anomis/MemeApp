package com.example.simonastojanovic.memeapp.view


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.simonastojanovic.memeapp.R
import com.example.simonastojanovic.memeapp.model.MemesItem
import com.squareup.picasso.Picasso
import java.util.*

class MemeAdapter(private val context: Context) : RecyclerView.Adapter<MemeAdapter.MemeAdapterViewHolder>() {

    private val memeList: ArrayList<MemesItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemeAdapterViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_view, parent, false)
        view.isFocusable = true
        return MemeAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: MemeAdapterViewHolder, position: Int) {
        Picasso.with(context).load(memeList[position].url).into(holder.memeImageView)

    }


    override fun getItemCount(): Int {
        return memeList.size
    }

    internal fun addResults(results: List<MemesItem>) {
        memeList.addAll(results)
        notifyDataSetChanged()
    }


    class MemeAdapterViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val memeImageView: ImageView = view.findViewById(R.id.meme_image_view) as ImageView

    }
}
