package com.example.mehndidesignapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PageViewAdapter extends FragmentPagerAdapter {


    public PageViewAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = null;

        switch(i){
            case 0:
                fragment = new DesignFragment();
                break;

            case 1:
                fragment = new PalmFragment();
                break;
            case 2:
                fragment = new ArmsFragment();
                break;
            case 3:
                fragment = new FeetFragment();
                break;
            case 4:
                fragment = new UpperHandFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
