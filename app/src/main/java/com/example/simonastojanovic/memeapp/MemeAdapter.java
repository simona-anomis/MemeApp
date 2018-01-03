package com.example.simonastojanovic.memeapp;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
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

        holder.memeImageView.setImageResource(R.drawable.ic_launcher_background);
        new DownloadImageTask(holder.memeImageView).execute(memeList.get(position).getImageUrl());

    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
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
