package com.example.kwongyo.recall.core;

import android.app.Application;

import com.example.kwongyo.recall.StaticInfomation;
import com.example.kwongyo.recall.adapter.ReCallAdapter;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kwongyo on 2016-05-20.
 */
public class RecallMainController extends Application {

    Retrofit retrofit;
    private static RecallMainController recallMainController;
    /*public static RecallMainController getInstance() {
        return recallMainController;
    }*/
    static {
        /*recallMainController = new RecallMainController();*/
        mInstance = new RecallMainController();
    }
    private RecallMainController() {

    }

    public boolean requestRecallMain() {
        retrofit = new Retrofit.Builder().baseUrl(StaticInfomation.TEST_REQUEST_URL).addConverterFactory(GsonConverterFactory.create()).build();
        return true;
    }


    /*temp*/
    ///get?format=xml&results_per_page=20
    private static RecallMainController mInstance;
    private OkHttpClient okHttpClient;


    public static synchronized RecallMainController getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public OkHttpClient getOkHttpClient() {
        if(okHttpClient == null){
            okHttpClient = new OkHttpClient();
        }
        return okHttpClient;
    }
}
