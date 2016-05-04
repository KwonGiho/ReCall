package com.example.kwongyo.recall.core;



import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kwongyo on 2016-05-03.
 */
public class RetrofitCreator {
    public static Retrofit getRetrofit(String url) {
        return new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
    }
}
