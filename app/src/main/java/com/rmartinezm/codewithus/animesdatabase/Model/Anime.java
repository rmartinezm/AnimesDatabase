package com.rmartinezm.codewithus.animesdatabase.Model;

import android.graphics.Bitmap;

public class Anime {

    private String name;
    private String image;
    private int seasons;
    private int episodes;
    private int watchedEpisodes;
    private float rating;


    private Anime(AnimeBuilder builder) {
        this.name = builder.name;
        this.image = builder.image;
        this.seasons = builder.seasons;
        this.episodes = builder.episodes;
        this.watchedEpisodes = builder.watchedEpisodes;
        this.rating = builder.rating;
    }

    public Anime(String name, String image, int seasons, int episodes, int watchedEpisodes, float rating) {
        this.name = name;
        this.image = image;
        this.seasons = seasons;
        this.episodes = episodes;
        this.watchedEpisodes = watchedEpisodes;
        this.rating = rating;
    }

    public Anime() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public int getWatchedEpisodes() {
        return watchedEpisodes;
    }

    public void setWatchedEpisodes(int watchedEpisodes) {
        this.watchedEpisodes = watchedEpisodes;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public static class AnimeBuilder {

        private String name;
        private String image;
        private int seasons;
        private int episodes;
        private int watchedEpisodes;
        private float rating;

        public AnimeBuilder(){}

        public AnimeBuilder name(String name){
            this.name = name;
            return this;
        }

        public AnimeBuilder image(String image){
            this.image = image;
            return this;
        }

        public AnimeBuilder seasons(int seasons){
            this.seasons = seasons;
            return this;
        }

        public AnimeBuilder episodes(int episodes){
            this.episodes = episodes;
            return this;
        }

        public AnimeBuilder watchedEpisodes(int watchedEpisodes){
            this.watchedEpisodes = watchedEpisodes;
            return this;
        }

        public AnimeBuilder rating(float rating){
            this.rating = rating;
            return this;
        }

        public Anime build(){
            return new Anime(this);
        }

    }
}
