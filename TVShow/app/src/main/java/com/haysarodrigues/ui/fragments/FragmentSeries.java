package com.haysarodrigues.ui.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.haysarodrigues.model.Series;
import com.haysarodrigues.repository.database.AppDatabase;
import com.haysarodrigues.ui.SerieActivity;
import com.haysarodrigues.ui.adapter.SeriesAdapter;
import com.haysarodrigues.tvshow.R;
import com.haysarodrigues.viewmodel.SeriesViewModel;

import java.util.List;


/**
 * Created by Haysa on 08/08/17.
 */

public class FragmentSeries extends android.support.v4.app.Fragment {

    public ListView listView;
    private SeriesViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_series, container, false);

        viewModel = ViewModelProviders.of(this).get(SeriesViewModel.class);
        viewModel.initLiveDataFromSeries();
        listView = view.findViewById(R.id.listView);

        SeriesAsync seriesAsync = new SeriesAsync();
        seriesAsync.execute();


        return view;
    }

    private void subscribeUiSerie(SeriesViewModel seriesViewModel) {

        seriesViewModel.getSeries().observe(this, series -> {
            if (series != null) {

                listView.setAdapter(new SeriesAdapter(getContext(), series.results));

            }

        });

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        listView.setOnItemClickListener((adapterView, view1, i, l) -> {

            SeriesAdapter seriesAdapter = (SeriesAdapter) adapterView.getAdapter();
            String serie = (String) seriesAdapter.getName(i);
            String over = (String) seriesAdapter.getOverview(i);
            String imagePath = (String) seriesAdapter.getImagePath(i);
            String backdrop_path = (String) seriesAdapter.getBackdrop_path(i);


            Intent intent = new Intent(getActivity(), SerieActivity.class);
            intent.putExtra("titleSerie", serie);
            intent.putExtra("overview", over);
            intent.putExtra("imagePath", imagePath);
            intent.putExtra("backdrop_path", backdrop_path);

            startActivity(intent);

        });
    }



    private class SeriesAsync extends AsyncTask<String, Void, List<Series>> {

        List<Series> seriesList;
        private final AppDatabase appDatabase;


        private SeriesAsync(AppDatabase database) {

            appDatabase = database;
        }

        @Override
        protected List<Series> doInBackground(String... strings) {

            subscribeUiSerie(viewModel);
            return seriesList;
            addSerie()

        }
    }

    private static Series.Serie addSerie (final AppDatabase database, Series.Serie series){
        database.serieDao().insertAllSeries(series);
        return series;
    }

}
