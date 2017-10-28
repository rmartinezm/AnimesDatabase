package com.rmartinezm.codewithus.animesdatabase.Model;

import android.provider.BaseColumns;

public class AnimeContract {

    public AnimeContract(){}

    public static class AnimeEntry implements BaseColumns {

        public static final String TABLE_NAME = "AnimesDatabase";

        public static final String NAME = "name";
        public static final String IMAGE = "image";
        public static final String SEASONS = "seasons";
        public static final String EPISODES = "episodes";
        public static final String WATCHED_EPISODES = "watchedEpisodes";
        public static final String RATING = "rating";

    }

}
