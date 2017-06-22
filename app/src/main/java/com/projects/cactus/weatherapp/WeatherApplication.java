package com.projects.cactus.weatherapp;

/**
 * Created by el on 6/21/2017.
 */

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class WeatherApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/weather.ttf.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

    }


}