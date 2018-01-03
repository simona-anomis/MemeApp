package com.example.simonastojanovic.memeapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MemeAdapter memeAdapter;

    private int position = RecyclerView.NO_POSITION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);

        memeAdapter = new MemeAdapter(this);
        recyclerView.setAdapter(memeAdapter);

        UriDownloadAsyncTask uriDownloadAsyncTask = new UriDownloadAsyncTask();
        uriDownloadAsyncTask.execute();

    }

    private class UriDownloadAsyncTask extends AsyncTask<String, Void, ArrayList<Meme>> {
        @Override
        protected ArrayList<Meme> doInBackground(String... params) {
            String uri = QueryUtils.getMemeUri();
            return QueryUtils.fetchResultData(uri);
        }

        @Override
        protected void onPostExecute(ArrayList<Meme> result) {

            memeAdapter.addResults(result);



        }
    }






}
