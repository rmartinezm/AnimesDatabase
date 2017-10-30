package com.rmartinezm.codewithus.animesdatabase.View.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
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

        presenter = new SplashScreenPresenterImpl(SplashScreenActivity.this);
        presenter.initialiceData(new DataCallback(){
            @Override
            public void onComplete() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        findViewById(R.id.splashscreen_progressBar).setVisibility(View.INVISIBLE);
                        Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }, 1200);
            }
        });

    }

    @Override
    public Context getContext() {
        return this;
    }

    public interface DataCallback {
        void onComplete();
    }

}
