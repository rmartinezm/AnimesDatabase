package com.rmartinezm.codewithus.animesdatabase.Interactor;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.rmartinezm.codewithus.animesdatabase.Interfaces.MainInteractor;
import com.rmartinezm.codewithus.animesdatabase.Model.Anime;
import com.rmartinezm.codewithus.animesdatabase.Model.AnimeContract.AnimeEntry;
import com.rmartinezm.codewithus.animesdatabase.Model.AnimeDbHelper;

public class MainInteractorImpl implements MainInteractor {

    private SQLiteDatabase db;

    public MainInteractorImpl(Context context) {
        AnimeDbHelper dbHelper = new AnimeDbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    @Override
    public void addAnimeDatabase(Anime anime) {
        ContentValues values = new ContentValues();
        values.put(AnimeEntry.NAME, anime.getName());
        values.put(AnimeEntry.IMAGE, anime.getImage());
        values.put(AnimeEntry.SEASONS, String.valueOf(anime.getSeasons()));
        values.put(AnimeEntry.EPISODES, String.valueOf(anime.getEpisodes()));
        values.put(AnimeEntry.WATCHED_EPISODES, String.valueOf(anime.getWatchedEpisodes()));
        values.put(AnimeEntry.RATING, String.valueOf(anime.getRating()));

        db.insert(AnimeEntry.TABLE_NAME, null, values);
    }
}
