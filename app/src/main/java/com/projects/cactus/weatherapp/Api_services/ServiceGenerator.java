package com.projects.cactus.weatherapp.Api_services;


import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ServiceGenerator {

    private static final String BASE_URL = "http://api.openweathermap.org";


    private static Retrofit retrofit;

//   static Gson gson = new GsonBuilder()
//            .setLenient()
//            .create();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());


    private static OkHttpClient.Builder httpClient =
            new OkHttpClient.Builder();

    public static <S> S createService(
            Class<S> serviceClass) {

            retrofit = builder.build();
        return retrofit.create(serviceClass);
    }


   public static RequestBody createFromString(String string){
        RequestBody requestBody=RequestBody.create(MediaType.parse("text"),string);
        return requestBody;
    }



}