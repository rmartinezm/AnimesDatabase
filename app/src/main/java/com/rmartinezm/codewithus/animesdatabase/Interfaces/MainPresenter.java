package com.rmartinezm.codewithus.animesdatabase.Interfaces;


import android.support.v7.widget.RecyclerView;

import com.rmartinezm.codewithus.animesdatabase.Model.Anime;

import java.util.LinkedList;

public interface MainPresenter {

    void setList(LinkedList<Anime> list);
    void setAdapter(RecyclerView recyclerView);
    void addNewAnime(String name, String image, String seasons, String episodes, String watchedEpisodes, float rating);
}
