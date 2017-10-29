package com.rmartinezm.codewithus.animesdatabase.Interfaces;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

public interface AnimeAdapterPresenter {

    void setImage(final ImageView imageView, String image);
    Context getContext();

}
