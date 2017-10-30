package com.rmartinezm.codewithus.animesdatabase.View.Activity;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RatingBar;

import com.rmartinezm.codewithus.animesdatabase.Interfaces.MainPresenter;
import com.rmartinezm.codewithus.animesdatabase.Interfaces.MainView;
import com.rmartinezm.codewithus.animesdatabase.Model.BundleAuxClass;
import com.rmartinezm.codewithus.animesdatabase.Presenter.MainPresenterImpl;
import com.rmartinezm.codewithus.animesdatabase.R;

public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener {

    private MainPresenter presenter;
    private RecyclerView recyclerView;
    private CoordinatorLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = (CoordinatorLayout) findViewById(R.id.main_coordinator_layout);
        presenter = new MainPresenterImpl(this);

        // Inicializamos nuestra lista que guardamos en BundleAuxClass del SplashScreen
        presenter.setList(BundleAuxClass.list);


        recyclerView = (RecyclerView) findViewById(R.id.main_recyclerview);
        presenter.setAdapter(recyclerView);

        // FloatingActionButton to add a new Anime
        findViewById(R.id.main_fab_add).setOnClickListener(this);

    }

    @Override
    public void showErrorAdd() {
        Snackbar snackbar = Snackbar.make(layout, "Error al agregar", Snackbar.LENGTH_SHORT);
        snackbar.getView().setBackgroundColor(Color.RED);
        snackbar.show();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_fab_add:
                showAlertDialogAdd();
                break;
        }
    }

    private void showAlertDialogAdd() {
        final View view = LayoutInflater.from(this).inflate(R.layout.alertdialog_add, layout,false);

        // Abrimos nuestro cuadro de dialogo
        new AlertDialog.Builder(this)
                .setTitle("Agregar un Anime")
                .setView(view)
                .setNegativeButton("Cancelar", null)
                .setPositiveButton("Agregar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String addURLImage, addName, addSeasons, addEpisodes, addWatchedEpisodes;
                        float addRating;

                        addName = ((EditText) view.findViewById(R.id.add_name)).getText().toString().trim();
                        addURLImage = ((EditText) view.findViewById(R.id.add_urlImage)).getText().toString().trim();
                        addSeasons = ((EditText) view.findViewById(R.id.add_seasons)).getText().toString().trim();
                        addEpisodes = (((EditText) view.findViewById(R.id.add_episodes)).getText().toString().trim());
                        addWatchedEpisodes = ((EditText) view.findViewById(R.id.add_watched_episodes)).getText().toString().trim();
                        addRating = ((RatingBar) view.findViewById(R.id.add_rating_bar)).getRating();

                        presenter.addNewAnime(addName, addURLImage, addSeasons, addEpisodes, addWatchedEpisodes, addRating);
                    }
                })
                .show();
    }

}
