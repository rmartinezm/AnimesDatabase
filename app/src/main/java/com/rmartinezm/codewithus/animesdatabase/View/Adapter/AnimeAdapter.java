package com.rmartinezm.codewithus.animesdatabase.View.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rmartinezm.codewithus.animesdatabase.Interfaces.AnimeAdapterPresenter;
import com.rmartinezm.codewithus.animesdatabase.Model.Anime;
import com.rmartinezm.codewithus.animesdatabase.Presenter.AnimeAdapterPresenterImpl;
import com.rmartinezm.codewithus.animesdatabase.R;

import java.util.LinkedList;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;
        private ImageView ivImage;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.animeadapter_name);
            ivImage = (ImageView) itemView.findViewById(R.id.animeadapter_image);
        }
    }

    private Context context;
    private LinkedList<Anime> list;
    private AnimeAdapterPresenter presenter;

    public AnimeAdapter(Context context, LinkedList<Anime> list){
        this.context = context;
        this.list = list;
        presenter = new AnimeAdapterPresenterImpl(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.anime_adapter_recyclerview, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Anime anime = list.get(position);
        holder.tvName.setText(anime.getName());

        presenter.setImage(holder.ivImage, anime.getImage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
