package com.example.simonastojanovic.memeapp.memelist.view.adapter.viewholder

import android.view.View
import com.example.simonastojanovic.memeapp.app.view.adapter.BaseViewHolder
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item_view.*

class MemeAdapterViewHolder(override val containerView: View) : BaseViewHolder(containerView){

    fun showImage(url : String?){
        Picasso.with(containerView.context).load(url).into(meme_image_view)
    }

}
