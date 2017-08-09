package com.haysarodrigues.listmoviesandseries;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.haysarodrigues.tvshow.R;

/**
 * Created by Haysa on 08/08/17.
 */

public class SerieActivity extends AppCompatActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serie);

        /* Leva o título sendo o item da lista */
        String serie = getIntent().getStringExtra("serie");
        TextView text = (TextView) findViewById(R.id.textSerie);
        text.setText(serie);
        getSupportActionBar().setTitle(serie);
    }
}
