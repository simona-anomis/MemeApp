package com.example.simonastojanovic.memeapp.domain;

import android.arch.lifecycle.MutableLiveData;

import com.example.simonastojanovic.memeapp.model.Data;
import com.example.simonastojanovic.memeapp.model.MemeRepository;
import com.example.simonastojanovic.memeapp.model.MemesItem;
import com.example.simonastojanovic.memeapp.model.Response;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class FetchMemeUseCaseImpl implements FetchMemeUseCase {

    private MemeRepository memeRepository = new MemeRepository();

    @Override
    public void execute(final MutableLiveData<ArrayList<MemesItem>> memeLiveData) {
        memeRepository.getMemeList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Response response) {
                        Data memes = response.getData();

                        List<MemesItem> memeList = memes.getMemes();

                        ArrayList<MemesItem> memeArrayList = new ArrayList<>();

                        for (int i = 0; i < memeList.size(); i++) {
                            MemesItem memeItem = new MemesItem();
                            memeItem.setUrl(memeList.get(i).getUrl());
                            memeArrayList.add(memeItem);
                        }

                        memeLiveData.setValue(memeArrayList);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
