package com.projects.cactus.weatherapp.presenter;

import android.util.Log;

import com.projects.cactus.weatherapp.data_layer.WeatherDataManager;
import com.projects.cactus.weatherapp.model.WeatherData;
import com.projects.cactus.weatherapp.view_layer.views.WeatherView;

/**
 * Created by el on 6/20/2017.
 */

public class WeatherPresenter implements WeatherPresenterContract {
    private WeatherView weatherView;
    WeatherDataManager weatherDataManager;
    private String TAG="WeatherPresenter";

    public WeatherPresenter(WeatherView weatherView) {
        weatherDataManager=new WeatherDataManager(this);
        this.weatherView = weatherView;
    }




    @Override
    public void getWeatherData(String daily, String cityName, String mode, String unit, String type, String cnt, String APPID) {
        weatherView.showLoading();
        weatherDataManager.getWeatherData(daily,cityName,mode,unit,type,cnt,APPID);

    }

    @Override
    public void onSuccess(WeatherData weather) {
        weatherView.hideLoading();
        weatherView.populateRecyclerView(weather);

    }

    @Override
    public void onFailure(String error) {
        weatherView.hideLoading();
        weatherView.showError();
        Log.d(TAG,"error is --->"+error);
    }


}
