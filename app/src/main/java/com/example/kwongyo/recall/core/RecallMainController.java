package com.example.kwongyo.recall.core;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.kwongyo.recall.StaticInfomation;
import com.example.kwongyo.recall.activitySupport.Image;
import com.example.kwongyo.recall.adapter.ReCallAdapter;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
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
    public void setImage(final AppCompatActivity activity,final ReCallAdapter reCallAdapter) {
        Request request = new Request.Builder()
                .url(StaticInfomation.TEST_REQUEST_URL).build();

        final Serializer serializer = new Persister();

        getOkHttpClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            com.example.kwongyo.recall.activitySupport.Response example;
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String string = response.body().string();
                    Log.d("xml", string);
                    example = serializer.read(com.example.kwongyo.recall.activitySupport.Response.class, string);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (example == null) {
                                    return;
                                }
                                for (Image image : example.getData().getImages()) {
                                    reCallAdapter.add(image);
                                }
                            }
                        });
                    }
                }).start();
            }
        });
    }
}
