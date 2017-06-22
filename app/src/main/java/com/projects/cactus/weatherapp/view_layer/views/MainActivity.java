package com.projects.cactus.weatherapp.view_layer.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.projects.cactus.weatherapp.R;
import com.projects.cactus.weatherapp.base_adapters.WeatherPagerAdapter;
import com.projects.cactus.weatherapp.util.WeatherUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements WeaklyWeatherFragment.CityCommunicator{

    private   List<Fragment> pages;
    private List<String> titles;
    private WeatherPagerAdapter weatherPagerAdapter;
    private ViewPager weatherPager;
    private TabLayout tabLayout;
    private String TAG="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initializeViews();

    }

    void initializeViews(){

        tabLayout= (TabLayout) findViewById(R.id.tabeLayout);
        pages=new ArrayList<>();
        titles=new ArrayList<>();
        pages.add(new DailyWatherFragment());
        titles.add("Daily");
        pages.add(new WeaklyWeatherFragment());
        titles.add("Weakly");
        weatherPagerAdapter = new WeatherPagerAdapter(getSupportFragmentManager(),this,pages,titles);
        weatherPager = (ViewPager) findViewById(R.id.weatherViewPagerID);
        weatherPager.setAdapter(weatherPagerAdapter);
       tabLayout.setupWithViewPager(weatherPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this,SettingActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
   public  String getCity(){
        String city=getApplicationContext().getSharedPreferences(WeatherUtils.PREF_NAME,0).getString(WeatherUtils.CITY_KEY,"cairo");;
        Log.d(TAG,"city stored is ----> "+city);
        return city;
    }
}
