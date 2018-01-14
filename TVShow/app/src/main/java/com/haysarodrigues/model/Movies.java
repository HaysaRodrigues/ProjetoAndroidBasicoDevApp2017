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

        @ColumnInfo(name = "vote_average")
        @SerializedName("vote_average")
        private String vote_average;

        @ColumnInfo(name = "poster_path")
        @SerializedName("poster_path")
        private String poster_path;

        public Movie(String title, String overview, String vote_average, String poster_path) {

            this.title = title;
            this.overview = overview;
            this.vote_average = vote_average;
            this.poster_path = poster_path;

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
