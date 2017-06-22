package com.projects.cactus.weatherapp.data_layer;

/**
 * Created by el on 6/20/2017.
 */

public interface WheatherDataMangerContract {



    void getWeatherData(String daily,String cityName, String mode, String unit, String type, String cnt, String APPID);
}
