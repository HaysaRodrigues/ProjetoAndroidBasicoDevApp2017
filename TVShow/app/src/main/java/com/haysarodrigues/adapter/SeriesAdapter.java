package com.haysarodrigues.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.haysarodrigues.tvshow.R;

/**
 * Created by Haysa on 08/08/17.
 */

public class SeriesAdapter extends BaseAdapter {

    private String [] series = new String[] {"House of Cards", "Game of Thrones", "Modern Family", "The Big Bang Theory", "House",
            "Grey's Anatomy", "Suits", "Friends", "Vikings", "Castlevania", "The Walking Dead", "Stranger Things", "13 Reasons Why", "How to Get Away with Murder", "Orphan Black"} ;


    private Context context;

    public SeriesAdapter(Context context){
        super();
        this.context = context;
    }


    @Override
    public int getCount() {

        return series.length;
    }

    @Override
    public Object getItem(int i) {

        return series[i];
    }

    @Override
    public long getItemId(int i) {

        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        String serie = series[i];
        View viewSeries = LayoutInflater.from(context).inflate(R.layout.adapter_series, viewGroup, false);
        TextView tw = (TextView) viewSeries.findViewById(R.id.textAdapterSeries);
        tw.setText(serie);
        return viewSeries;
    }
}
