package com.example.simonastojanovic.memeapp.view;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.simonastojanovic.memeapp.model.Meme;
import com.example.simonastojanovic.memeapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MemeAdapter extends RecyclerView.Adapter<MemeAdapter.MemeAdapterViewHolder> {

    private Context context;
    private ArrayList<Meme> memeList;


    public MemeAdapter(Context context) {
        this.context = context;
        memeList = new ArrayList<Meme>();
    }

    @Override
    public MemeAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_view, parent, false);
        view.setFocusable(true);
        return new MemeAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MemeAdapterViewHolder holder, int position) {
        Picasso.with(context).load(memeList.get(position).getImageUrl()).into(holder.memeImageView);

    }


    @Override
    public int getItemCount() {
        return memeList.size();
    }

    void addResults(List<Meme> results) {
        memeList.addAll(results);
        notifyDataSetChanged();
    }


    class MemeAdapterViewHolder extends RecyclerView.ViewHolder {

        final ImageView memeImageView;

        MemeAdapterViewHolder(View view) {
            super(view);

            memeImageView = (ImageView) view.findViewById(R.id.meme_image_view);

        }
    }
}
