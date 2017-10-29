package com.rmartinezm.codewithus.animesdatabase.View.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rmartinezm.codewithus.animesdatabase.Interfaces.SplashScreenPresenter;
import com.rmartinezm.codewithus.animesdatabase.Interfaces.SplashScreenView;
import com.rmartinezm.codewithus.animesdatabase.Model.Anime;
import com.rmartinezm.codewithus.animesdatabase.Model.BundleAuxClass;
import com.rmartinezm.codewithus.animesdatabase.Presenter.SplashScreenPresenterImpl;
import com.rmartinezm.codewithus.animesdatabase.R;

import java.util.LinkedList;

public class SplashScreenActivity extends AppCompatActivity implements SplashScreenView {

    private SplashScreenPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        presenter = new SplashScreenPresenterImpl(this);
        presenter.initialiceData();

    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void navigateToMainActivity(LinkedList<Anime> list) {
        String jsonList = new GsonBuilder().create().toJson(list);
        Intent intent = new Intent(this, MainActivity.class);
        BundleAuxClass.json = jsonList;
        startActivity(intent);
        finish();
    }
}
