package com.rmartinezm.codewithus.animesdatabase.Interfaces;

import android.content.Context;

import com.rmartinezm.codewithus.animesdatabase.Model.Anime;

import java.util.LinkedList;

public interface SplashScreenView {

    Context getContext();
    void navigateToMainActivity(LinkedList<Anime> list);

}
