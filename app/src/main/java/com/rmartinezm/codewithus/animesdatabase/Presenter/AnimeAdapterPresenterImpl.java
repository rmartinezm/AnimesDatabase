package com.rmartinezm.codewithus.animesdatabase.Presenter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.rmartinezm.codewithus.animesdatabase.Interactor.AnimeAdapterInteractorImpl;
import com.rmartinezm.codewithus.animesdatabase.Interfaces.AnimeAdapterInteractor;
import com.rmartinezm.codewithus.animesdatabase.Interfaces.AnimeAdapterPresenter;
import com.rmartinezm.codewithus.animesdatabase.Model.Util;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;


public class AnimeAdapterPresenterImpl implements AnimeAdapterPresenter {

    private Context context;
    private AnimeAdapterInteractor interactor;

    public AnimeAdapterPresenterImpl(Context context){
        this.context = context;
        interactor = new AnimeAdapterInteractorImpl(this);
    }

    @Override
    public void setImage(final ImageView imageView, final String image) {
        if (Util.StringToBitMap(image) != null)
            imageView.setImageBitmap(Util.StringToBitMap(image));
        else {
            Picasso.with(context).load(image).into(imageView, new Callback() {
                @Override
                public void onSuccess() {
                    Drawable drawable = imageView.getDrawable();
                    if (drawable != null) {
                        Bitmap bitmap = Util.drawableToBitmap(drawable);
                        if (bitmap != null) {
                            imageView.setImageBitmap(bitmap);
                            interactor.upgradeData(image, Util.BitMapToString(bitmap));
                        }
                    }
                }

                @Override
                public void onError() {}
            });
        }
    }

    @Override
    public Context getContext() {
        return context;
    }


}
