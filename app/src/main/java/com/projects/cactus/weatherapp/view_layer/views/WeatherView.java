package com.projects.cactus.weatherapp.view_layer.views;

import com.projects.cactus.weatherapp.model.WeatherData;

/**
 * Created by el on 6/20/2017.
 */

public interface WeatherView {

    void showLoading();
    void hideLoading();
    void showError();
    void getWeatherData();

    void populateRecyclerView(WeatherData weather);
}
