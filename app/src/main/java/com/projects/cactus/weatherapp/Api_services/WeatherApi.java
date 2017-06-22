package com.projects.cactus.weatherapp.Api_services;


import com.projects.cactus.weatherapp.model.WeatherData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by el on 4/15/2017.
 */
public interface WeatherApi {

    @GET("/data/2.5/forecast/{daily}")
    Call<WeatherData> getWeatherData(
            @Path("daily") String daily,
            @Query("q") String cityName,
            @Query("mode") String mode,
            @Query("units") String units,
            @Query("type") String type,
            @Query("cnt") String cnt,
            @Query("APPID") String apiId);

}
