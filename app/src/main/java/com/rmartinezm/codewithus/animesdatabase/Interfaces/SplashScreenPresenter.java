package com.rmartinezm.codewithus.animesdatabase.Interfaces;

import com.rmartinezm.codewithus.animesdatabase.Model.Anime;

public interface SplashScreenPresenter {

    void initialiceData();
    Anime createAnime(String name, String image, String seasons, String episodes, String watchedEpisodes, String rating);

}
