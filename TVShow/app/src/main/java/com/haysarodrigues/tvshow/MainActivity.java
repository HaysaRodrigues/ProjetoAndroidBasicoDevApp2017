package com.haysarodrigues.tvshow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * Menu lado direito da main activity
     * @param menu
     * @return
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_about){
            Intent mIntent = new Intent(this, AboutActivity.class);
            startActivity(mIntent);
            return true;

        } else if (id == R.id.action_license){

            Intent mIntent = new Intent(this, LicenseActivity.class);
            startActivity(mIntent);
            return true;

        }

        return super.onOptionsItemSelected(item);

    }
}
