package com.projects.cactus.weatherapp.view_layer.views;

import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.projects.cactus.weatherapp.R;

import static com.projects.cactus.weatherapp.util.WeatherUtils.CITY_KEY;
import static com.projects.cactus.weatherapp.util.WeatherUtils.PREF_NAME;

public class SettingActivity extends ListActivity implements SettingsView {


    private static final String TAG = "SettingActivity";
    private SharedPreferences sharedPreferences;
    ArrayAdapter<String> citiesArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        citiesArrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.city_list));
        setListAdapter(citiesArrayAdapter);
        sharedPreferences = getApplicationContext().getSharedPreferences(PREF_NAME,0);

    }
    @Override
    public void storeCity(String city) {
        sharedPreferences.edit().putString(CITY_KEY,city).commit();

    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Log.d(TAG,"city to be restored ---> "+getResources().getStringArray(R.array.city_list)[position]);
        storeCity(getResources().getStringArray(R.array.city_list)[position]);
        startActivity(new Intent(this,MainActivity.class));
    }
}
