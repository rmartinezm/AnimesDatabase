package com.rmartinezm.codewithus.animesdatabase.View.Activity;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import com.rmartinezm.codewithus.animesdatabase.Interfaces.MainPresenter;
import com.rmartinezm.codewithus.animesdatabase.Interfaces.MainView;
import com.rmartinezm.codewithus.animesdatabase.Model.AnimeContract.AnimeEntry;
import com.rmartinezm.codewithus.animesdatabase.Model.AnimeDbHelper;
import com.rmartinezm.codewithus.animesdatabase.Presenter.MainPresenterImpl;
import com.rmartinezm.codewithus.animesdatabase.R;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener {

    private MainPresenter presenter;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        progressBar = (ProgressBar) findViewById(R.id.main_progressbar);
        presenter = new MainPresenterImpl(this);

        // Inicializamos nuestra lista con el JSON que recibimos del SplashScreen
        Bundle bundle = getIntent().getExtras();
        if (bundle == null)
            finish();
        presenter.initialiceList(bundle.getString("jsonList").trim());


        recyclerView = (RecyclerView) findViewById(R.id.main_recyclerview);
        presenter.setAdapter(recyclerView);

        // FloatingActionButton to add a new Anime
        findViewById(R.id.main_fab_add).setOnClickListener(this);

    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            // TODO
            case R.id.main_fab_add:
                AnimeDbHelper dbHelper = new AnimeDbHelper(this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put(AnimeEntry.NAME, "Shigatsu wa kimi no uso");
                values.put(AnimeEntry.IMAGE, "jafdl");
                values.put(AnimeEntry.SEASONS, "1");
                values.put(AnimeEntry.EPISODES, "22");
                values.put(AnimeEntry.WATCHED_EPISODES, "22");
                values.put(AnimeEntry.RATING, "5.0");

                db.insert(AnimeEntry.TABLE_NAME, null, values);
                break;

        }
    }

}
