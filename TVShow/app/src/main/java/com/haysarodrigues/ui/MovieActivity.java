package com.haysarodrigues.ui;

import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.haysarodrigues.tvshow.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Haysa on 09/08/17.
 */

public class MovieActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        String title = getIntent().getStringExtra("movie");
        TextView textView = findViewById(R.id.titleMovie);
        textView.setText(title);


        String releaseDate = getIntent().getStringExtra("releaseDate");
        TextView releaseDateTextView = findViewById(R.id.releaseDate);
        releaseDateTextView.setText(releaseDate);

        String overview = getIntent().getStringExtra("overview");
        TextView textOverview = findViewById(R.id.textMovieOverview);
        textOverview.setText(overview);
        textOverview.setMovementMethod(new ScrollingMovementMethod());

        String voteAverage = getIntent().getStringExtra("voteAverage");
        TextView voteAverageTextView = findViewById(R.id.voteAverage);
        voteAverageTextView.setText(voteAverage);

        String poster = getIntent().getStringExtra("imagePath");
        ImageView posterMovie = findViewById(R.id.posterMoviePath);
        Picasso.with(this).load(poster).into(posterMovie);

        String imageBackdropPath = getIntent().getStringExtra("imageBackdropPath");
        ImageView posterBackdrop = findViewById(R.id.backdropPathMovie);
        Picasso.with(this).load(imageBackdropPath).into(posterBackdrop);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }



}
