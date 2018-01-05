package com.example.simonastojanovic.memeapp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.simonastojanovic.memeapp.R;
import com.example.simonastojanovic.memeapp.model.Meme;
import com.example.simonastojanovic.memeapp.model.MemesItem;
import com.example.simonastojanovic.memeapp.network.ApiInterface;
import com.example.simonastojanovic.memeapp.network.RetrofitClient;
import com.example.simonastojanovic.memeapp.presenter.MemePresenter;
import com.example.simonastojanovic.memeapp.presenter.MemePresenterImpl;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements MainView {

    private RecyclerView recyclerView;
    private MemeAdapter memeAdapter;
    private MemePresenter presenter = new MemePresenterImpl(this);

    private ApiInterface apiInterface;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpRecyclerView();


        presenter.fetchMemes();

    }



    private void setUpRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        memeAdapter = new MemeAdapter(this);
        recyclerView.setAdapter(memeAdapter);
    }

    @Override
    public void onMemesFetched(ArrayList<Meme> memes) {
        memeAdapter.addResults(memes);
    }

}
