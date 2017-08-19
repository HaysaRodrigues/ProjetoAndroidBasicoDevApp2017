package com.haysarodrigues.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.haysarodrigues.tvshow.R;

/**
 * Created by Haysa on 08/08/17.
 */

public class SerieActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serie);

        /* Outra forma de setar o click listener*/
        findViewById(R.id.buttonWishList).setOnClickListener(this);

        /* Leva o título sendo o item da lista */
        String serie = getIntent().getStringExtra("serie");
        TextView text = (TextView) findViewById(R.id.textSerie);
        text.setText(serie);
        getSupportActionBar().setTitle(serie);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }

    @Override
    public void onClick(View view) {

        Intent intent = new Intent(new Intent("WISHLIST"));
        sendBroadcast(intent);

    }

    public void onClickSearchWeb(View view){
        String serie = getIntent().getStringExtra("serie");
        String url = "https://www.google.com.br/search?q=" + serie ;
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

}
