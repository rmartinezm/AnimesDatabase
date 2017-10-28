package com.rmartinezm.codewithus.animesdatabase.Interfaces;


import android.support.v7.widget.RecyclerView;

import com.rmartinezm.codewithus.animesdatabase.Model.Anime;

import java.util.LinkedList;

public interface MainPresenter {

    void initialiceList(String jsonString);
    LinkedList<Anime> getList();
    void setAdapter(RecyclerView recyclerView);

}
