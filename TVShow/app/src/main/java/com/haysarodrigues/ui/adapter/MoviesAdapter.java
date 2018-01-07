package com.haysarodrigues.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.haysarodrigues.model.Movies;
import com.haysarodrigues.tvshow.R;

import java.util.List;

/**
 * Created by Haysa on 09/08/17.
 */

public class MoviesAdapter extends ArrayAdapter<Movies.Movie> {

    private List<Movies.Movie> movies;


    public MoviesAdapter(Context context, List<Movies.Movie> movies) {
        super(context, 0, movies);
        this.movies = movies;
    }

    public Object getTitle(int i) {
        return movies.get(i).getTitle();
    }

    public Object getOverview(int i) {

        return movies.get(i).getOverview();
    }

    public Object getVoteAverage(int i) {

        return movies.get(i).getVote_average();
    }

    public Object getPosterPath(int i) {
        return movies.get(i).getPoster_path();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        Movies.Movie movie = getItem(position);
        View viewMovies = LayoutInflater.from(getContext()).inflate(R.layout.adapter_movies, viewGroup, false);

        TextView tw = viewMovies.findViewById(R.id.textAdapterMovies);
        tw.setText(movie.getTitle());
        return viewMovies;

    }

}
