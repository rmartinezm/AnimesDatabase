package com.rmartinezm.codewithus.animesdatabase.Interfaces;

import android.content.Context;

import com.rmartinezm.codewithus.animesdatabase.Model.Anime;

import java.util.LinkedList;

public interface SplashScreenInteractor {

    LinkedList<Anime> readDatabase(Context context);

}
