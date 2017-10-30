package com.rmartinezm.codewithus.animesdatabase.Presenter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rmartinezm.codewithus.animesdatabase.Interactor.MainInteractorImpl;
import com.rmartinezm.codewithus.animesdatabase.Interfaces.MainInteractor;
import com.rmartinezm.codewithus.animesdatabase.Interfaces.MainPresenter;
import com.rmartinezm.codewithus.animesdatabase.Interfaces.MainView;
import com.rmartinezm.codewithus.animesdatabase.Model.Anime;
import com.rmartinezm.codewithus.animesdatabase.View.Adapter.AnimeAdapter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainPresenterImpl implements MainPresenter {

    private MainView view;
    private MainInteractor interactor;
    private LinkedList<Anime> list;
    private AnimeAdapter adapter;

    public MainPresenterImpl(MainView view){
        this.view = view;
        interactor = new MainInteractorImpl(view.getContext());
    }

    @Override
    public void setList(LinkedList<Anime> list) {
        this.list = list;
    }

    @Override
    public void setAdapter(RecyclerView recyclerView) {
        adapter = new AnimeAdapter(view.getContext(), list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

    @Override
    public void addNewAnime(String name, String image, String seasons, String episodes, String watchedEpisodes, float rating) {
        if (name.isEmpty() || image.isEmpty() || seasons.isEmpty() || episodes.isEmpty() || watchedEpisodes.isEmpty()) {
            view.showErrorAdd();
            return;
        }
        Anime anime = new Anime.AnimeBuilder()
                .name(name)
                .image(image)
                .seasons(Integer.valueOf(seasons))
                .episodes(Integer.valueOf(episodes))
                .watchedEpisodes(Integer.valueOf(watchedEpisodes))
                .rating(rating)
                .build();
        list.add(anime);
        adapter.notifyItemInserted(list.size());
        interactor.addAnimeDatabase(anime);
    }

}

