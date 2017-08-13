package com.haysarodrigues.tvshow;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Haysa on 08/08/17.
 */

public class TabsAdapter extends FragmentPagerAdapter {

    public TabsAdapter(FragmentManager supportFragmentManager){

        super(supportFragmentManager);
    }


    @Override
    public Fragment getItem(int position) {

        if(position == 0){
            return new FragmentSeries();
        }

        // default return
        return new FragmentMovies();

    }

    @Override
    public int getCount() {

        return 2;
    }
}
