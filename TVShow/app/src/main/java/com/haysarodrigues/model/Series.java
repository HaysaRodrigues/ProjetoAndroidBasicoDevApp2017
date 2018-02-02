package com.haysarodrigues.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Haysa on 25/08/17.
 */

public class Series {

    @SerializedName("results")
    public List<Serie> results;

    public class Serie {

        @SerializedName("name")
        private String name;
        @SerializedName("overview")
        private String overview;
        @SerializedName("poster_path")
        private String poster_path;
        @SerializedName("backdrop_path")
        private String backdrop_path;

        public Serie(String name, String overview, String poster_path, String backdrop_path) {

            this.name = name;
            this.overview = overview;
            this.poster_path = poster_path;
            this.backdrop_path = backdrop_path;

        }

        public String getName() {
            return name;
        }


        public String getOverview() {
            return overview;
        }


        public String getPoster_path() {
            return "http://image.tmdb.org/t/p/w154/" + poster_path;
        }

        public String getBackdrop_path() {
            return "http://image.tmdb.org/t/p/w500/" + backdrop_path;
        }

    }

}
