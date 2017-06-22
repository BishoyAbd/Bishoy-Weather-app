package com.projects.cactus.weatherapp.presenter;


import com.projects.cactus.weatherapp.model.Weather;
import com.projects.cactus.weatherapp.model.WeatherData;

/**
 * Created by el on 6/20/2017.
 */

public interface WeatherPresenterContract {

        void onSuccess(WeatherData wather);
        void onFailure(String error);
        void getWeatherData(String daily, String cityName, String mode, String unit, String type, String cnt, String APPID);




}
