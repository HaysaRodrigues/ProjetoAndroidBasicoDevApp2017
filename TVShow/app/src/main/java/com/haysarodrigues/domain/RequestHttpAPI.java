package com.haysarodrigues.domain;

import com.haysarodrigues.model.ResultMoviesAPI;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Haysa on 20/08/17.
 */

public interface RequestHttpAPI {

    @GET("results")
    Call<ResultMoviesAPI> loadMovies(@Query("apiKey") String apiKey);

}
