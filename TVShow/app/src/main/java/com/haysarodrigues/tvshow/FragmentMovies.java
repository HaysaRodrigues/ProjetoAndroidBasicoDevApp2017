package com.haysarodrigues.tvshow;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.haysarodrigues.listmoviesandseries.MovieActivity;
import com.haysarodrigues.listmoviesandseries.MoviesAdapter;

/**
 * Created by Haysa on 08/08/17.
 */

public class FragmentMovies extends android.support.v4.app.Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_movies, container, false);

        ListView listView = (ListView) view.findViewById(R.id.listViewMovies);
        listView.setAdapter(new MoviesAdapter(getActivity()));
        listView.setOnItemClickListener(onItemClickMovies());

        return view;
    }


    private AdapterView.OnItemClickListener onItemClickMovies(){
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                MoviesAdapter mAdapter = (MoviesAdapter) adapterView.getAdapter();
                String movie = (String) mAdapter.getItem(i);

                Intent intent = new Intent(getActivity(), MovieActivity.class);
                intent.putExtra("movie", movie);
                startActivity(intent);



            }
        };
    }
}
