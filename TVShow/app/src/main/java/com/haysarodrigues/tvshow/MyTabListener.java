package com.haysarodrigues.tvshow;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;

/**
 * Created by Haysa on 08/08/17.
 */

public class MyTabListener implements ActionBar.TabListener {

    private ViewPager viewPager;
    private int position;


    public MyTabListener(ViewPager view, int position){

        this.viewPager = view;
        this.position = position;

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        viewPager.setCurrentItem(position);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
