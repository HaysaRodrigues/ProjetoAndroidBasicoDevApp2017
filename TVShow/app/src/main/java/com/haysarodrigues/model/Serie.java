package com.haysarodrigues.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Haysa on 25/08/17.
 */

public class Serie {

    @SerializedName("name")
    private String name;
    @SerializedName("vote_average")
    private String vote_average;
    @SerializedName("overview")
    private String overview;
    @SerializedName("poster_path")
    private String poster_path;

    public Serie(String name, String vote_average, String overview, String poster_path){

        this.name = name;
        this.vote_average = vote_average;
        this.overview = overview;
        this.poster_path = poster_path;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }
}
