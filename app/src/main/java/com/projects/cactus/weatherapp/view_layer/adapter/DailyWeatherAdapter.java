package com.projects.cactus.weatherapp.view_layer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by el on 6/20/2017.
 */

public class DailyWeatherAdapter extends RecyclerView.Adapter<DailyWeatherAdapter.DailyViewHolder> {

    WeatherData weatherData;
    Context mContext;
    String iconUrl="http://openweathermap.org/img/w/";
    private String TAG="WeeklyWeatherAdapter";


    public DailyWeatherAdapter(Context context,WeatherData weatherData) {
        this.mContext = context;
        this.weatherData = weatherData;
    }

    @Override
    public DailyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.daily_recycler_row,parent,false);
        return new DailyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DailyViewHolder holder, int position) {
        initConvertView(weatherData.getList().get(position),holder);
    }

    private void initConvertView(List item, DailyViewHolder vHolder) {
        initDateValue(item, vHolder);
        initTemperatureMaxValue(item, vHolder);
        initWeatherValue(item, vHolder);
        initIconDrawable(item, vHolder);
        initPressureValue(item,vHolder);
        initHumidity(item,vHolder);
        initCityName(weatherData,vHolder);
    }

    private void initDateValue(List item,DailyViewHolder  vHolder) {
    String date=DateUtils.formatDate(item.getDt());
        vHolder.dDate.setText(date);
        vHolder.dDay.setText(DateUtils.getDayName(mContext,(long)item.getDt()*1000));
    }

    private void initTemperatureMaxValue(List item, DailyViewHolder vHolder) {
        vHolder.dHighTemp.setText(mContext.getString(R.string.temp_metrics, Math.round(item.getTemp().getMax())));
        vHolder.dLowTemp.setText(mContext.getString(R.string.temp_metrics, Math.round(item.getTemp().getMin())));

    }



    private void initIconDrawable(List item, DailyViewHolder vHolder) {
        int iconName = item.getWeather().get(0).getId();
        int icon = ImageUtils.getArtResourceForWeatherCondition(iconName);
        Glide.with(mContext).load(icon).into(vHolder.dIcon);
    }

    private void initWeatherValue(List item, DailyViewHolder vHolder) {
        String description = item.getWeather().get(0).getDescription();
        vHolder.dDescription.setText(StringUtils.capitalizeString(description));
    }


    private void initPressureValue(List item, DailyViewHolder vHolder) {
        String pressure = item.getPressure().toString();
        vHolder.dPressureVal.setText(pressure);
    }

    private void initCityName(WeatherData item, DailyViewHolder vHolder) {
        String cityName = item.getCity().getName();
        vHolder.dCity.setText(StringUtils.capitalizeString(cityName));
    }

    private void initHumidity(List item, DailyViewHolder vHolder) {
        String hum = String.valueOf(item.getHumidity());
        vHolder.dHumidityVal.setText(hum);
    }


    @Override
    public int getItemCount() {
        return weatherData.getList().size();
    }

    public  class DailyViewHolder extends RecyclerView.ViewHolder {

        TextView dDay;
        TextView dDate;
        TextView dCity;
        TextView dHighTemp;
        TextView dLowTemp;
        TextView dDescription;
        TextView dHumidityDesc;
        TextView dHumidityVal;
        TextView dPressureDesc;
        TextView dPressureVal;
        TextView dWindDesc;
        TextView dWindVal;
        ImageView dIcon;




        DailyViewHolder(View itemView) {
            super(itemView);
            dDate = (TextView) itemView.findViewById(R.id.dDate);
            dDay = (TextView) itemView.findViewById(R.id.dDay);
            dCity = (TextView) itemView.findViewById(R.id.dCity);
            dHighTemp = (TextView) itemView.findViewById(R.id.dHighTemp);
            dLowTemp = (TextView) itemView.findViewById(R.id.dLowTemp);
            dIcon = (ImageView) itemView.findViewById(R.id.dIcon);
            dDescription = (TextView) itemView.findViewById(R.id.dDescription);
            dHumidityDesc = (TextView) itemView.findViewById(R.id.dHumidityDesc);
            dHumidityVal = (TextView) itemView.findViewById(R.id.dHumidityVal);
            dPressureDesc = (TextView) itemView.findViewById(R.id.dPressureDesc);
            dPressureVal = (TextView) itemView.findViewById(R.id.dPressureVal);




        }
    }
}
