package com.rmartinezm.codewithus.animesdatabase.Presenter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rmartinezm.codewithus.animesdatabase.Interfaces.MainPresenter;
import com.rmartinezm.codewithus.animesdatabase.Interfaces.MainView;
import com.rmartinezm.codewithus.animesdatabase.Model.Anime;
import com.rmartinezm.codewithus.animesdatabase.View.Adapter.AnimeAdapter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainPresenterImpl implements MainPresenter {

    private MainView view;
    private LinkedList<Anime> list;

    public MainPresenterImpl(MainView view){
        this.view = view;
    }

    @Override
    public void initialiceList(String jsonString) {
        view.showProgressBar();
        if (jsonString.isEmpty())
            list = new LinkedList<>();
        else
          list = new LinkedList<>(
                  (ArrayList<Anime>) new Gson().fromJson(jsonString,
                          new TypeToken<List<Anime>>(){}.getType()));
    }

    @Override
    public LinkedList<Anime> getList() {
        return list;
    }

    @Override
    public void setAdapter(RecyclerView recyclerView) {
        AnimeAdapter adapter = new AnimeAdapter(view.getContext(), list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        view.hideProgressBar();
    }


}

