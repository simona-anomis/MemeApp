package com.example.simonastojanovic.memeapp.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.simonastojanovic.memeapp.R;
import com.example.simonastojanovic.memeapp.model.MemesItem;
import com.example.simonastojanovic.memeapp.viewmodel.MemeViewModel;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MemeAdapter memeAdapter;
    private MemeViewModel memeViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpRecyclerView();
        memeViewModel = ViewModelProviders.of(this).get(MemeViewModel.class);
        observeViewModel();
        memeViewModel.getMemeList();
    }

    private void observeViewModel() {
        memeViewModel.getMemeLiveData().observe(this, new Observer<ArrayList<MemesItem>>() {
            @Override
            public void onChanged(@Nullable ArrayList<MemesItem> memes) {
                if (memes != null) {
                    memeAdapter.addResults(memes);
                }
            }
        });
    }


    private void setUpRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        memeAdapter = new MemeAdapter(this);
        recyclerView.setAdapter(memeAdapter);
    }

}
