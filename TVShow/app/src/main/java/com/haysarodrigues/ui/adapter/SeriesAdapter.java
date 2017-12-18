package com.haysarodrigues.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.haysarodrigues.model.Series;
import com.haysarodrigues.tvshow.R;

import java.util.List;

/**
 * Created by Haysa on 08/08/17.
 */

public class SeriesAdapter extends ArrayAdapter<Series.Serie> {

    private List<Series.Serie> series;

    public SeriesAdapter(Context context, List<Series.Serie> series) {
        super(context, 0, series);
        this.series = series;

    }

    public Object getName(int i) {
        return series.get(i).getName();
    }

    public Object getOverview(int i) {
        return series.get(i).getOverview();
    }

    public Object getImagePath(int i) {
        return series.get(i).getPoster_path();
    }

    public Object getBackdrop_path(int i) {
        return series.get(i).getBackdrop_path();
    }


    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        Series.Serie series = getItem(position);
        View viewSeries = LayoutInflater.from(getContext()).inflate(R.layout.adapter_series, viewGroup, false);
        TextView tw = viewSeries.findViewById(R.id.textAdapterSeries);
        tw.setText(series.getName());
        return viewSeries;
    }

}
