package com.rmartinezm.codewithus.animesdatabase.Interfaces;

import com.rmartinezm.codewithus.animesdatabase.Model.Anime;
import com.rmartinezm.codewithus.animesdatabase.View.Activity.SplashScreenActivity.DataCallback;

public interface SplashScreenPresenter {

    void initialiceData(DataCallback callback);
    void navigateToMainActivity();
    Anime createAnime(String name, String image, String seasons, String episodes, String watchedEpisodes, String rating);

}
