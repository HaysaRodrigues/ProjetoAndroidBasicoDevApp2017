package com.haysarodrigues.ui.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.haysarodrigues.ui.adapter.MoviesAdapter;
import com.haysarodrigues.repository.api.Util;
import com.haysarodrigues.model.Movies;
import com.haysarodrigues.tvshow.R;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Haysa on 08/08/17.
 */

public class FragmentMovies extends android.support.v4.app.Fragment {

    private static final String TAG = "FragmentMovies";
    public static ListView listView;
    public static final String pURL =
            "https://api.themoviedb.org/3/discover/movie?api_key=782f2aaaee7308f5db36241b029cf5e9";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_movies, container, false);
        listView = view.findViewById(R.id.listViewMovies);

        if (Util.checkIsConnect(getContext())) {
            GetMoviesTask getMoviesTask = new GetMoviesTask();
            getMoviesTask.execute(pURL);
        }

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

            moviesList = new ArrayList<>();

            String url = strings[0];
            InputStream inputStream = Util.getStream(url);

            String body = Util.convertStreamToString(inputStream);

            moviesList = Util.parseJson(body);

            return moviesList;
        }


        @Override
        protected void onPostExecute(List<Movies> movies) {
            super.onPostExecute(movies);

            Log.i(TAG, "Call onPostExecute from AsyncTask");
            listView.setAdapter(new MoviesAdapter(getContext(), movies));

        }
    }
}
