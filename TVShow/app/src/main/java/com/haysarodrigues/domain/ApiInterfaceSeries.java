package com.haysarodrigues.domain;

import com.haysarodrigues.model.SeriesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Haysa on 25/08/17.
 */

public interface ApiInterfaceSeries {

    @GET("discover/tv")
    Call<SeriesResponse> getSeriesTv(@Query("api_key") String apiKey);

}
