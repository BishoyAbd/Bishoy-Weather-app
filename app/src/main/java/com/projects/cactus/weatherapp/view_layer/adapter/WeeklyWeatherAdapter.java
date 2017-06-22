package com.projects.cactus.weatherapp.view_layer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.projects.cactus.weatherapp.R;
import com.projects.cactus.weatherapp.model.List;
import com.projects.cactus.weatherapp.model.WeatherData;
import com.projects.cactus.weatherapp.util.DateUtils;
import com.projects.cactus.weatherapp.util.ImageUtils;
import com.projects.cactus.weatherapp.util.StringUtils;

import java.util.Date;

/**
 * Created by el on 6/20/2017.
 */

public class WeeklyWeatherAdapter extends RecyclerView.Adapter<WeeklyWeatherAdapter.CityViewHolder> {

    WeatherData weatherData;
    Context mContext;
    String iconUrl="http://openweathermap.org/img/w/";
    private String TAG="WeeklyWeatherAdapter";


    public WeeklyWeatherAdapter(Context context, WeatherData weatherData) {
        this.mContext = context;
        this.weatherData = weatherData;
    }

    @Override
    public CityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.weekly_recycler_row,parent,false);
        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CityViewHolder holder, int position) {
      initConvertView(weatherData.getList().get(position),holder);
    }

    private void initConvertView(List item, CityViewHolder vHolder) {
        initDateValue(item, vHolder);
        initTemperatureMaxValue(item, vHolder);
        initTemperatureMinValue(item, vHolder);
        initWeatherValue(item, vHolder);
        initIconDrawable(item, vHolder);
    }

    private void initDateValue(List item,CityViewHolder  vHolder) {
        String day=DateUtils.formatDate(item.getDt());
        vHolder.forecastItemDate.setText(DateUtils.getDayName(mContext,(long)item.getDt()*1000));
        Log.d(TAG,day);
    }

    private void initTemperatureMaxValue(List item, CityViewHolder vHolder) {
        vHolder.forecastItemTemperatureMax.setText(mContext.getString(R.string.temp_metrics,
                Math.round(item.getTemp().getMax())));
    }

    private void initTemperatureMinValue(List item, CityViewHolder vHolder) {
        vHolder.forecastItemTemperatureMin.setText(mContext.getString(
                R.string.temp_metrics, Math.round(item.getTemp().getMin())));
    }

    private void initIconDrawable(List item, CityViewHolder vHolder) {
        int iconName = item.getWeather().get(0).getId();
        int icon = ImageUtils.getIconResourceForWeatherCondition(iconName);
        Glide.with(mContext).load(icon).into(vHolder.forecastItemIcon);
    }

    private void initWeatherValue(List item, CityViewHolder vHolder) {
        String description = item.getWeather().get(0).getDescription();
        vHolder.forecastItemDescription.setText(StringUtils.capitalizeString(description));
    }


    @Override
    public int getItemCount() {
        return weatherData.getList().size();
    }

    public  class CityViewHolder extends RecyclerView.ViewHolder {

        ImageView forecastItemIcon;
        TextView forecastItemDate;
        TextView forecastItemDescription;
        TextView forecastItemTemperatureMin;
        TextView forecastItemTemperatureMax;

        CityViewHolder(View itemView) {
            super(itemView);
            forecastItemIcon = (ImageView) itemView.findViewById(R.id.forecastItemIcon);
            forecastItemDate = (TextView) itemView.findViewById(R.id.forecastItemDate);
            forecastItemDescription = (TextView) itemView.findViewById(R.id.forecastItemDescription);
            forecastItemTemperatureMin = (TextView) itemView.findViewById(R.id.forecastItemTemperatureMin);
            forecastItemTemperatureMax = (TextView) itemView.findViewById(R.id.forecastItemTemperatureMax);
        }
    }

}
