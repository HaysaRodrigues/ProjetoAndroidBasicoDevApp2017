package com.haysarodrigues.tvshow;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.haysarodrigues.listmoviesandseries.SerieActivity;
import com.haysarodrigues.listmoviesandseries.SeriesAdapter;


/**
 * Created by Haysa on 08/08/17.
 */

public class FragmentSeries extends android.support.v4.app.Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_series, container, false);


        ListView listView = (ListView) view.findViewById(R.id.listView);
        listView.setAdapter(new SeriesAdapter(getActivity()));
        listView.setOnItemClickListener(onItemClickSeries());

        return view;

    }

    private AdapterView.OnItemClickListener onItemClickSeries(){
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                SeriesAdapter sAdapter = (SeriesAdapter) adapterView.getAdapter();
                String serie = (String) sAdapter.getItem(i);

                Intent intent = new Intent(getActivity(), SerieActivity.class);
                intent.putExtra("serie", serie);
                startActivity(intent);

            }
        };
    }

}
