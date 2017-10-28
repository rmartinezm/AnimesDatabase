package com.rmartinezm.codewithus.animesdatabase.Interactor;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.rmartinezm.codewithus.animesdatabase.Interfaces.SplashScreenInteractor;
import com.rmartinezm.codewithus.animesdatabase.Interfaces.SplashScreenPresenter;
import com.rmartinezm.codewithus.animesdatabase.Model.Anime;
import com.rmartinezm.codewithus.animesdatabase.Model.AnimeContract.AnimeEntry;
import com.rmartinezm.codewithus.animesdatabase.Model.AnimeDbHelper;

import java.util.LinkedList;


public class SplashScreenInteractorImpl implements SplashScreenInteractor {

    private SplashScreenPresenter presenter;

    public SplashScreenInteractorImpl(SplashScreenPresenter presenter){
        this.presenter = presenter;
    }

    @Override
    public LinkedList<Anime> readDatabase(Context context) {
        LinkedList<Anime> list = new LinkedList<>();

        AnimeDbHelper dbHelper = new AnimeDbHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] projection = {
                AnimeEntry._ID,
                AnimeEntry.NAME,
                AnimeEntry.IMAGE,
                AnimeEntry.SEASONS,
                AnimeEntry.EPISODES,
                AnimeEntry.WATCHED_EPISODES,
                AnimeEntry.RATING,
        };
        Cursor c = db.query(
                AnimeEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        // Si la base de datos no esta vacía
        if (c.moveToFirst()) {
            // El primer elemento
            list.add(
                    presenter.createAnime(
                            c.getString(c.getColumnIndexOrThrow(AnimeEntry.NAME)),
                            c.getString(c.getColumnIndexOrThrow(AnimeEntry.IMAGE)),
                            c.getString(c.getColumnIndexOrThrow(AnimeEntry.SEASONS)),
                            c.getString(c.getColumnIndexOrThrow(AnimeEntry.EPISODES)),
                            c.getString(c.getColumnIndexOrThrow(AnimeEntry.WATCHED_EPISODES)),
                            c.getString(c.getColumnIndexOrThrow(AnimeEntry.RATING))
                            )
            );

            // Todos los demás
            while (c.moveToNext())
                list.add(
                        presenter.createAnime(
                                c.getString(c.getColumnIndexOrThrow(AnimeEntry.NAME)),
                                c.getString(c.getColumnIndexOrThrow(AnimeEntry.IMAGE)),
                                c.getString(c.getColumnIndexOrThrow(AnimeEntry.SEASONS)),
                                c.getString(c.getColumnIndexOrThrow(AnimeEntry.EPISODES)),
                                c.getString(c.getColumnIndexOrThrow(AnimeEntry.WATCHED_EPISODES)),
                                c.getString(c.getColumnIndexOrThrow(AnimeEntry.RATING))
                        )
                );
        }

        return list;
    }
}
