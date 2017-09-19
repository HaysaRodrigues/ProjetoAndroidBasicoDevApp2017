package com.haysarodrigues.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.haysarodrigues.adapter.SeriesAdapter;
import com.haysarodrigues.domain.APIClient;
import com.haysarodrigues.domain.ApiInterfaceSeries;
import com.haysarodrigues.model.Serie;
import com.haysarodrigues.model.SeriesResponse;
import com.haysarodrigues.tvshow.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Haysa on 08/08/17.
 */

public class FragmentSeries extends android.support.v4.app.Fragment {

    private static final String TAG = "FragmentSeries";
    private final static String API_KEY = "782f2aaaee7308f5db36241b029cf5e9";
    public static ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_series, container, false);
        listView = (ListView) view.findViewById(R.id.listView);

        if (API_KEY.isEmpty()) {
            Toast.makeText(getContext(), "Invalid API Key", Toast.LENGTH_LONG).show();
        }

        ApiInterfaceSeries callApiInterfaceSeries = APIClient.getClient().create(ApiInterfaceSeries.class);

        Call<SeriesResponse> call = callApiInterfaceSeries.getSeriesTv(API_KEY);
        call.enqueue(new Callback<SeriesResponse>() {

            @Override
            public void onResponse(Call<SeriesResponse> call, Response<SeriesResponse> response) {

                List<Serie> series = response.body().getResults();
                listView.setAdapter(new SeriesAdapter(getContext(), series));
                Log.i(TAG, "Call onResponse from Callback");
            }

            @Override
            public void onFailure(Call<SeriesResponse> call, Throwable t) {
                Log.e("Series --->", t.toString());
            }
        });

        return view;

    }

}
