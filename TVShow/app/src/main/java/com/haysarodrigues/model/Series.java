package com.haysarodrigues.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Haysa on 25/08/17.
 */

public class Series {

    @SerializedName("results")
    public List<Serie> results;

    @Entity(tableName = "serie")
    public class Serie {

        @PrimaryKey(autoGenerate = true)
        private int uid;

        @ColumnInfo(name = "name")
        @SerializedName("name")
        private String name;

        @ColumnInfo(name = "overview")
        @SerializedName("overview")
        private String overview;

        @ColumnInfo(name = "poster_path")
        @SerializedName("poster_path")
        private String poster_path;

        @ColumnInfo(name = "backdrop_path")
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
