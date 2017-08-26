package com.haysarodrigues.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.haysarodrigues.model.Serie;
import com.haysarodrigues.tvshow.R;

import java.util.List;

/**
 * Created by Haysa on 08/08/17.
 */

public class SeriesAdapter extends BaseAdapter {

    private Context context;
    private List<Serie> series;

    public SeriesAdapter(Context context, List<Serie> series){
        super();
        this.context = context;
        this.series = series;
    }


    @Override
    public int getCount() {

        return series.size();
    }

    @Override
    public Object getItem(int i) {

        return series.get(i).getName();
    }

    @Override
    public long getItemId(int i) {

        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Serie serie = series.get(i);
        View viewSeries = LayoutInflater.from(context).inflate(R.layout.adapter_series, viewGroup, false);
        TextView tw = (TextView) viewSeries.findViewById(R.id.textAdapterSeries);
        tw.setText(serie.getName());
        return viewSeries;
    }
}
