package com.haysarodrigues.ui.fragments;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.haysarodrigues.database.AppDatabase;
import com.haysarodrigues.database.DatabaseInitializer;
import com.haysarodrigues.repository.api.APIClient;
import com.haysarodrigues.repository.api.WebServices;
import com.haysarodrigues.repository.service.MoviesService;
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

public class FragmentMovies extends android.support.v4.app.Fragment implements ServiceConnection{

    private static final String TAG = "FragmentMovies";
    public static ListView listView;
    List<Movies.Movie> moviesFromDB;
    private MoviesService s;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_movies, container, false);
        listView = view.findViewById(R.id.listViewMovies);

        Intent service = new Intent(getContext(), MoviesService.class);
        getContext().startService(service);

        moviesFromDB = AppDatabase.getAppDatabase(getContext()).moviesDao().getAll();
        listView.setAdapter(new MoviesAdapter(getContext(), moviesFromDB));


        return view;
    }


    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {

        MoviesService.MyBinder b = (MoviesService.MyBinder) service;
        s = b.getService();
        Toast.makeText(getContext(), "Connected", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onServiceDisconnected(ComponentName name) {}
}
