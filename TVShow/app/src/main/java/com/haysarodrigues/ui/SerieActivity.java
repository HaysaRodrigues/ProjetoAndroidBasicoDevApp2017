package com.haysarodrigues.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.haysarodrigues.tvshow.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Haysa on 08/08/17.
 */

public class SerieActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = SerieActivity.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serie);

        /* Outra forma de setar o click listener*/
        //findViewById(R.id.buttonWishList).setOnClickListener(this);


        String image = getIntent().getStringExtra("image");
        ImageView imageSerie = findViewById(R.id.imageViewSerie);
        Picasso.with(this).load(image).into(imageSerie);

        /* Leva o título sendo o item da lista */
        String title = getIntent().getStringExtra("titleSerie");
        TextView text = findViewById(R.id.titleSerie);
        text.setText(title);

        String overview = getIntent().getStringExtra("overview");
        TextView textOverview = findViewById(R.id.textOverview);
        textOverview.setText(overview);


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
