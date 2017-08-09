package com.haysarodrigues.tvshow;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;

/**
 * Created by Haysa on 08/08/17.
 */

public class MyTabListener implements ActionBar.TabListener {

   private ViewPager viewPager;
    private int index;


    public MyTabListener(ViewPager viewPager, int index){

        this.viewPager = viewPager;
        this.index = index;

    }


    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        viewPager.setCurrentItem(index);

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
