package com.haysarodrigues.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.haysarodrigues.model.Movie;
import com.haysarodrigues.tvshow.R;

import java.util.List;

/**
 * Created by Haysa on 09/08/17.
 */

public class MoviesAdapter extends BaseAdapter {

    private Context context;
    private final List<Movie> movies;


    public MoviesAdapter(Context context, List<Movie> movies){
        super();
        this.context = context;
        this.movies = movies;
    }

    @Override
    public int getCount() {

        return movies.size();
    }

    @Override
    public Object getItem(int i) {

        return movies.get(i).getTitle();
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Movie movie = movies.get(i);
        View viewMovies = LayoutInflater.from(context).inflate(R.layout.adapter_movies, viewGroup, false);
        TextView tw = viewMovies.findViewById(R.id.textAdapterMovies);
        tw.setText(movie.getTitle());
        return viewMovies;

    }

    public interface MovieOnClickListener {
        public void onClickMovie(AdapterView<?> adapterView, View view);
    }
}
