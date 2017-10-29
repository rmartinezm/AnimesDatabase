package com.rmartinezm.codewithus.animesdatabase.Interactor;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.rmartinezm.codewithus.animesdatabase.Interfaces.AnimeAdapterInteractor;
import com.rmartinezm.codewithus.animesdatabase.Interfaces.AnimeAdapterPresenter;
import com.rmartinezm.codewithus.animesdatabase.Model.AnimeContract.AnimeEntry;
import com.rmartinezm.codewithus.animesdatabase.Model.AnimeDbHelper;

public class AnimeAdapterInteractorImpl implements AnimeAdapterInteractor {

    private AnimeDbHelper dbHelper;

    public AnimeAdapterInteractorImpl(AnimeAdapterPresenter presenter){
        this.dbHelper = new AnimeDbHelper(presenter.getContext());
    }

    @Override
    public void upgradeData(String image, String bitmap) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // New value for one column
        ContentValues values = new ContentValues();
        values.put(AnimeEntry.IMAGE, bitmap);

        // Which row to update, based on the title
        String selection = AnimeEntry.IMAGE + " LIKE ?";
        String[] selectionArgs = { image };

        db.update(
                AnimeEntry.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

}
