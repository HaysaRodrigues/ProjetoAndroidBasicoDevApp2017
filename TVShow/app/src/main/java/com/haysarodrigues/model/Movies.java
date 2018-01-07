package com.haysarodrigues.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Haysa on 20/08/17.
 */

public class Movies {


    @SerializedName("results")
    public List<Movies.Movie> results;

    public class Movie {

        @SerializedName("title")
        private String title;
        @SerializedName("overview")
        private String overview;
        @SerializedName("vote_average")
        private String vote_average;
        @SerializedName("poster_path")
        private String poster_path;

        public Movie(String title, String overview, String vote_average, String poster_path) {

            this.title = title;
            this.overview = overview;
            this.vote_average = vote_average;
            this.poster_path = poster_path;

        }

        public String getTitle() {
            return title;
        }

        public String getOverview() {
            return overview;
        }

        public String getVote_average() {
            return vote_average;
        }

        public String getPoster_path() {
            return poster_path;
        }

    }

    public List<Movie> getResults() {
        return results;

    }

}
