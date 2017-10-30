package com.rmartinezm.codewithus.animesdatabase.Presenter;

import com.rmartinezm.codewithus.animesdatabase.Interactor.SplashScreenInteractorImpl;
import com.rmartinezm.codewithus.animesdatabase.Interfaces.SplashScreenInteractor;
import com.rmartinezm.codewithus.animesdatabase.Interfaces.SplashScreenPresenter;
import com.rmartinezm.codewithus.animesdatabase.Interfaces.SplashScreenView;
import com.rmartinezm.codewithus.animesdatabase.Model.Anime;
import com.rmartinezm.codewithus.animesdatabase.Model.BundleAuxClass;
import com.rmartinezm.codewithus.animesdatabase.View.Activity.SplashScreenActivity.DataCallback;

public class SplashScreenPresenterImpl implements SplashScreenPresenter {

    private SplashScreenView view;
    private SplashScreenInteractor interactor;
    private DataCallback callback;

    public SplashScreenPresenterImpl(SplashScreenView view){
        this.view = view;
        this.interactor = new SplashScreenInteractorImpl(this);
    }

    @Override
    public void initialiceData(DataCallback callback) {
        this.callback = callback;
        BundleAuxClass.list = interactor.readDatabase(view.getContext());
    }

    @Override
    public void navigateToMainActivity() {
        callback.onComplete();
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
