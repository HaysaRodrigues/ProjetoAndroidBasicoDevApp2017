package com.haysarodrigues.tvshow;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Lógica dos tabs */

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new TabsAdapter(getSupportFragmentManager()));

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(android.app.ActionBar.NAVIGATION_MODE_TABS);

        /* TAB 1 */
        actionBar.addTab(actionBar.newTab().setText("Series").
                setTabListener(new MyTabListener(viewPager, 0)));

        /* TAB 2 */
        actionBar.addTab(actionBar.newTab().setText("Movies").
                setTabListener(new MyTabListener(viewPager, 1)));


        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


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
