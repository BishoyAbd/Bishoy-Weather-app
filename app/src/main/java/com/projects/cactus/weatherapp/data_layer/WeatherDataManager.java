package com.projects.cactus.weatherapp.data_layer;

import com.projects.cactus.weatherapp.Api_services.ServiceGenerator;
import com.projects.cactus.weatherapp.Api_services.WeatherApi;
import com.projects.cactus.weatherapp.model.WeatherData;
import com.projects.cactus.weatherapp.presenter.WeatherPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by el on 6/20/2017.
 */

public class WeatherDataManager implements WheatherDataMangerContract {


    private WeatherPresenter weatherPresenter;

    public WeatherDataManager(WeatherPresenter weatherPresenter) {

        this.weatherPresenter = weatherPresenter;
    }

    @Override
    public void getWeatherData(String daily,String cityName, String mode, String unit, String type, String cnt, String APPID) {

        WeatherApi weatherApi = ServiceGenerator.createService(WeatherApi.class);
        Call<WeatherData> call = weatherApi.getWeatherData(daily,cityName, mode, unit, type, cnt, APPID);
        call.enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                weatherPresenter.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                weatherPresenter.onFailure(t.getLocalizedMessage());
            }
        });
    }
}
