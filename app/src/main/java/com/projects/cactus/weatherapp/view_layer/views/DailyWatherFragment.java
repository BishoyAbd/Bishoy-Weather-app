package com.projects.cactus.weatherapp.view_layer.views;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.projects.cactus.weatherapp.R;
import com.projects.cactus.weatherapp.model.WeatherData;
import com.projects.cactus.weatherapp.presenter.WeatherPresenter;
import com.projects.cactus.weatherapp.view_layer.adapter.DailyWeatherAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by el on 6/20/2017.
 */

public class DailyWatherFragment extends Fragment implements WeatherView {


    private String city;
    private final String mode = "json";
    private final String units = "metric";
    private final String type = "hour";
    private WeatherPresenter weatherPresenter;
    private static final String APPID="7ea6a8e823a2dc87b59301f6a971cac5";
    private String cnt="2";
    private  static final String TAG="DailyWatherFragment";

    DailyWeatherAdapter cityWeatherAdapter;
    @BindView(R.id.cityRecycler)
    RecyclerView recyclerView;
    private static final String DAILY="daily";
    private ProgressDialog progressDialog;
    private TextView errorTv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_daily,container,false);
        ButterKnife.bind(getActivity());
        initViews(view);
        prepareRecyclerView(view);
        city=((MainActivity)getActivity()).getCity();
        Log.d(TAG,"city stored is ----> "+city);
        weatherPresenter = new WeatherPresenter(this);
        weatherPresenter.getWeatherData(DAILY,city,mode,units,type,cnt,APPID);
        return view;
    }

    void initViews(View view){
        progressDialog=new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading");
        progressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        errorTv = (TextView) view.findViewById(R.id.errorTextView);
    }



    void prepareRecyclerView(View view){
        recyclerView= (RecyclerView) view.findViewById(R.id.dailyRecycler);
     recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }


    @Override
    public void showLoading() {
        if (!progressDialog.isShowing())
            progressDialog.show();
    }

    @Override
    public void hideLoading() {
        if (progressDialog.isShowing())
            progressDialog.hide();
    }

    @Override
    public void showError() {
        hideLoading();
        recyclerView.setVisibility(View.INVISIBLE);
        errorTv.setVisibility(View.VISIBLE);
    }



    @Override
    public void getWeatherData() {

    }

    @Override
    public void populateRecyclerView(WeatherData weather) {
        Log.d(TAG,"city is ---> "+weather.getCity().getName());
        cityWeatherAdapter=new DailyWeatherAdapter(getActivity(),weather);
        recyclerView.setAdapter(cityWeatherAdapter);

    }
}
