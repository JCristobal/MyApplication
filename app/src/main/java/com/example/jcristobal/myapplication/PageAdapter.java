package com.example.jcristobal.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by JCristobal on 27/04/2015.
 */
class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(android.support.v4.app.FragmentManager fm) {
        super(fm);
    }

    public Fragment getItem(int arg0) {
        switch (arg0) {
            case 0:
                return new Tab1();
            case 1:
                return new Tab2();
            case 2:
                return new Tab3();
            default:
                return null;
        }
    }

    public int getCount() {
        return 3;
    }

}