package com.rmartinezm.codewithus.animesdatabase.Presenter;

import com.rmartinezm.codewithus.animesdatabase.Interactor.SplashScreenInteractorImpl;
import com.rmartinezm.codewithus.animesdatabase.Interfaces.SplashScreenInteractor;
import com.rmartinezm.codewithus.animesdatabase.Interfaces.SplashScreenPresenter;
import com.rmartinezm.codewithus.animesdatabase.Interfaces.SplashScreenView;
import com.rmartinezm.codewithus.animesdatabase.Model.Anime;

import java.util.LinkedList;

public class SplashScreenPresenterImpl implements SplashScreenPresenter {

    private SplashScreenView view;
    private SplashScreenInteractor interactor;

    public SplashScreenPresenterImpl(SplashScreenView view){
        this.view = view;
        this.interactor = new SplashScreenInteractorImpl(this);
    }

    @Override
    public void initialiceData() {
        LinkedList<Anime> list = interactor.readDatabase(view.getContext());
        view.navigateToMainActivity(list);
    }

    @Override
    public Anime createAnime(String name, String image, String seasons, String episodes, String watchedEpisodes, String rating) {
        return new Anime.AnimeBuilder()
                .name(name)
                .image(image)
                .seasons(Integer.parseInt(seasons))
                .episodes(Integer.parseInt(episodes))
                .watchedEpisodes(Integer.parseInt(watchedEpisodes))
                .rating(Float.parseFloat(rating))
                .build();
    }

}
