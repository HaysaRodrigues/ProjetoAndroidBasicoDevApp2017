package com.haysarodrigues.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.haysarodrigues.tvshow.R;

/**
 * Created by Haysa on 09/08/17.
 */

public class MoviesAdapter extends BaseAdapter {

    private String [] movies = new String[] {"Ghost in the Shell", "Logan", "The Boss Baby", "The Shack", "Zombieland",
            "Avatar", "Wonder Woman", "Spider-Man", "Life", "Split", "Beauty and the Beast", "The Founder", "Why Him?",
            "Land of Mine", "Certain Women"} ;

    private Context context;

    public MoviesAdapter(Context context){
        super();
        this.context = context;
    }



    @Override
    public int getCount() {

        return movies.length;
    }

    @Override
    public Object getItem(int i) {

        return movies[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        String movie = movies [i];
        View viewMovies = LayoutInflater.from(context).inflate(R.layout.adapter_movies, viewGroup, false);
        TextView tw = (TextView) viewMovies.findViewById(R.id.textAdapterMovies);
        tw.setText(movie);
        return viewMovies;

    }
}
