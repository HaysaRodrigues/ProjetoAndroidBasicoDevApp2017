package com.haysarodrigues.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.haysarodrigues.tvshow.R;

public class AboutActivity extends AppCompatActivity {

    private static final String TAG = AboutActivity.class.getSimpleName();
    private final String URL = "https://github.com/HaysaRodrigues/ProjetoAndroidBasicoDevApp2017";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "Call onCreate");
        setContentView(R.layout.activity_about);

        getSupportActionBar().setTitle(R.string.action_about);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        onBackPressed();
        return true;
    }

    public void clickLink (View view){

        Log.i(TAG, "Got into clickLink function");
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(URL));
        startActivity(i);

    }
}
