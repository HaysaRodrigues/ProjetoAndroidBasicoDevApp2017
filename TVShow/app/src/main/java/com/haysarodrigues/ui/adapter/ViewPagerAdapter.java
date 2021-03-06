package com.haysarodrigues.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.haysarodrigues.ui.fragments.FragmentMovies;
import com.haysarodrigues.ui.fragments.FragmentSeries;

/**
 * Created by Haysa on 08/08/17.
 */

public class ViewPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager supportFragmentManager) {

        super(supportFragmentManager);
    }


    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new FragmentSeries();
        }

        return new FragmentMovies();

    }

    @Override
    public int getCount() {

        return 2;
    }
}
