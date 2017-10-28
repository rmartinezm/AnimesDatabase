package com.rmartinezm.codewithus.animesdatabase.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.rmartinezm.codewithus.animesdatabase.Model.AnimeContract.AnimeEntry;

public class AnimeDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "AnimesDatabase.db";

    private static final String TEXT_TYPE = " TEXT NOT NULL";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + AnimeEntry.TABLE_NAME + " (" +
                    AnimeEntry._ID + " INTEGER PRIMARY KEY," +
                    AnimeEntry.NAME + TEXT_TYPE + COMMA_SEP +
                    AnimeEntry.IMAGE + TEXT_TYPE + COMMA_SEP +
                    AnimeEntry.SEASONS + TEXT_TYPE + COMMA_SEP +
                    AnimeEntry.EPISODES + TEXT_TYPE + COMMA_SEP +
                    AnimeEntry.WATCHED_EPISODES + TEXT_TYPE + COMMA_SEP +
                    AnimeEntry.RATING + TEXT_TYPE + " )";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + AnimeEntry.TABLE_NAME;

    /**
     * Constructor
     */
    public AnimeDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}
