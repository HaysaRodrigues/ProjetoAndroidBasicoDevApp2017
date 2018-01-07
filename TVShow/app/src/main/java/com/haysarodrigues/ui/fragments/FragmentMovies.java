package com.haysarodrigues.ui.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.haysarodrigues.repository.api.APIClient;
import com.haysarodrigues.repository.api.WebServices;
import com.haysarodrigues.ui.adapter.MoviesAdapter;
import com.haysarodrigues.model.Movies;
import com.haysarodrigues.tvshow.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Haysa on 08/08/17.
 */

public class FragmentMovies extends android.support.v4.app.Fragment {

    private static final String TAG = "FragmentMovies";
    public static ListView listView;
    List<Movies.Movie> movies;
    private final static String API_KEY = "782f2aaaee7308f5db36241b029cf5e9";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_movies, container, false);
        listView = view.findViewById(R.id.listViewMovies);

        GetMoviesTask getMoviesTask = new GetMoviesTask();
        getMoviesTask.execute();

        return view;
    }


    private class GetMoviesTask extends AsyncTask<String, Void, List<Movies>> {

        List<Movies> moviesList;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.i(TAG, "Call onPreExecute from AsyncTask");

        }

        @Override
        protected List<Movies> doInBackground(String... strings) {

            Log.i(TAG, "Call doInBackground from AsyncTask");

            WebServices webServices = APIClient.getClient().create(WebServices.class);

            Call<Movies> call = webServices.getMovies(API_KEY);

            call.enqueue(new Callback<Movies>() {
                @Override
                public void onResponse(Call<Movies> call, Response<Movies> response) {
                    movies = response.body().getResults();
                    listView.setAdapter(new MoviesAdapter(getContext(), movies));
                    Log.i(TAG, "Call onResponse from Callback");

                }

                @Override
                public void onFailure(Call<Movies> call, Throwable t) {
                    Log.e("onfailure movies --->", t.toString());
                }
            });

            return moviesList;
        }


        @Override
        protected void onPostExecute(List<Movies> movies) {
            super.onPostExecute(movies);
            Log.i(TAG, "Call onPostExecute from AsyncTask");

        }
    }
}
