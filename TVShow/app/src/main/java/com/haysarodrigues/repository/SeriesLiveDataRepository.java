package com.haysarodrigues.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.haysarodrigues.model.Series;
import com.haysarodrigues.repository.api.APIClient;
import com.haysarodrigues.repository.api.WebServices;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Haysa on 12/12/17.
 */

public class SeriesLiveDataRepository {

    private WebServices webServices = APIClient.getClient().create(WebServices.class);
    private final static String API_KEY = "782f2aaaee7308f5db36241b029cf5e9";


    public LiveData<Series> getLiveDataSeries() {

        final MutableLiveData<Series> data = new MutableLiveData<>();

        webServices.getSeriesTv(API_KEY).enqueue(new Callback<Series>() {
            @Override
            public void onResponse(Call<Series> call, Response<Series> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Series> call, Throwable t) {
                Log.d(SeriesLiveDataRepository.class.getSimpleName(), "onFailure:getLiveDataSeries");
            }
        });

        return data;
    }
}