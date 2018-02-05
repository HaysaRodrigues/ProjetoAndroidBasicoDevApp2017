package com.haysarodrigues.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Haysa on 20/08/17.
 */

public class Movies {

    @SerializedName("results")
    public List<Movies.Movie> results;

    @Entity(tableName = "movie")
    public static class Movie {


        @PrimaryKey(autoGenerate = true)
        private int uid;

        @ColumnInfo(name = "title")
        @SerializedName("title")
        private String title;

        @ColumnInfo(name = "overview")
        @SerializedName("overview")
        private String overview;

        @ColumnInfo(name = "release_date")
        @SerializedName("release_date")
        private String release_date;

        @ColumnInfo(name = "vote_average")
        @SerializedName("vote_average")
        private String vote_average;

        @ColumnInfo(name = "poster_path")
        @SerializedName("poster_path")
        private String poster_path;

        @ColumnInfo(name = "backdrop_path")
        @SerializedName("backdrop_path")
        private String backdrop_path;

        public Movie(String title, String overview, String vote_average, String poster_path, String backdrop_path, String release_date) {

            this.title = title;
            this.overview = overview;
            this.release_date = release_date;
            this.vote_average = vote_average;
            this.poster_path = poster_path;
            this.backdrop_path = backdrop_path;

        }

        public int uid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getTitle() {
            return title;
        }

        public String getOverview() {
            return overview;
        }

        public String getRelease_date() {
            return release_date;
        }

        public String getVote_average() {
            return vote_average;
        }

        public String getPoster_path() {
            return "http://image.tmdb.org/t/p/w154/" + poster_path;
        }

        public String getBackdrop_path() {
            return "http://image.tmdb.org/t/p/w500/" + backdrop_path;
        }

    }

    public List<Movie> getResults() {
        return results;

    }

}
