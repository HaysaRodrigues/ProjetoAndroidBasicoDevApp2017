package com.haysarodrigues.ui.fragments;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.haysarodrigues.database.AppDatabase;
import com.haysarodrigues.repository.service.MoviesService;
import com.haysarodrigues.ui.MovieActivity;
import com.haysarodrigues.ui.adapter.MoviesAdapter;
import com.haysarodrigues.model.Movies;
import com.haysarodrigues.tvshow.R;

import java.util.List;


/**
 * Created by Haysa on 08/08/17.
 */

public class FragmentMovies extends android.support.v4.app.Fragment implements ServiceConnection{

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

        listView.setOnItemClickListener((adapterView, view1, i, l) -> {

            String movie = moviesFromDB.get(i).getTitle();
            String overview = moviesFromDB.get(i).getOverview();
            String releaseDate = moviesFromDB.get(i).getRelease_date();
            String voteAverage = moviesFromDB.get(i).getVote_average();
            String imagePath = moviesFromDB.get(i).getPoster_path();
            String imageBackdropPath = moviesFromDB.get(i).getBackdrop_path();

            Intent intent = new Intent(getActivity(), MovieActivity.class);
            intent.putExtra("movie", movie);
            intent.putExtra("overview", overview);
            intent.putExtra("releaseDate", releaseDate);
            intent.putExtra("voteAverage", voteAverage);
            intent.putExtra("imagePath", imagePath);
            intent.putExtra("imageBackdropPath", imageBackdropPath);

            startActivity(intent);

        });


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
