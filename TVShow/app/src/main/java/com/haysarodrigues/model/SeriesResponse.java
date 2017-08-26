package com.haysarodrigues.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Haysa on 20/08/17.
 */

public class SeriesResponse {

    @SerializedName("page")
    private int page;
    @SerializedName("results")
    private List<Serie> results;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("total_pages")
    private int totalPages;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Serie> getResults() {
        return results;
    }

    public void setResults(List<Serie> results) {
        this.results = results;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
