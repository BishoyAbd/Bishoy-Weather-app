package com.projects.cactus.weatherapp.base_adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by el on 6/20/2017.
 */

public class WeatherPagerAdapter extends FragmentPagerAdapter {


    List<Fragment> pages;
    private List<String> titles;
    Context ctx;


    public WeatherPagerAdapter(FragmentManager fm, Context context, List<Fragment> pages, List<String> titles) {
        super(fm);
        this.pages = pages;
        this.titles = titles;
        this.ctx=context;
    }

    public WeatherPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        pages = new ArrayList<>();
        titles = new ArrayList<>();
        this.ctx=context;

    }

    public void addFragment(Fragment newFrag, String newTitle) {
        pages.add(newFrag);
        titles.add(newTitle);
    }


    @Override
    public Fragment getItem(int position) {
        return pages.get(position);
    }

    @Override
    public int getCount() {
        return pages.size();
    }

      @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

}


