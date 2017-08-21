package com.haysarodrigues.model;

import java.util.List;

/**
 * Created by Haysa on 20/08/17.
 */

public class ResultMoviesAPI {

    private String status;
    private List<Movie> results;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }


}
