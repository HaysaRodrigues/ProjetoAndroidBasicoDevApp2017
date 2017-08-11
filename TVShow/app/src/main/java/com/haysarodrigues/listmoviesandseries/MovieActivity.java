package com.haysarodrigues.listmoviesandseries;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.haysarodrigues.tvshow.R;

/**
 * Created by Haysa on 09/08/17.
 */

public class MovieActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        findViewById(R.id.buttonWishList2).setOnClickListener(this);

        String movie = getIntent().getStringExtra("movie");
        TextView textView = (TextView) findViewById(R.id.textMovie);
        textView.setText(movie);
        getSupportActionBar().setTitle(movie);
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
        //Toast.makeText(this, "broadcast enviado", Toast.LENGTH_SHORT).show();

    }

}
