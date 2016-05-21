package com.example.kwongyo.recall;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.kwongyo.recall.activitySupport.Image;
import com.example.kwongyo.recall.adapter.ReCallAdapter;
import com.example.kwongyo.recall.core.RecallMainController;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by kwongyo on 2016-05-20.
 */
public class RecallMainActivity extends AppCompatActivity{
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;
    ReCallAdapter reCallAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recall_main_activity);
        ButterKnife.bind(this);
        gridLayoutManager = new GridLayoutManager(this,2);

        /*Log.d("gridLayoutManager_",gridLayoutManager.toString());*/
        recyclerView.setLayoutManager(gridLayoutManager);


        Request request = new Request.Builder()
                .url(StaticInfomation.TEST_REQUEST_URL).build();
        reCallAdapter = new ReCallAdapter(getApplicationContext(),null);
        recyclerView.setAdapter(reCallAdapter);

        final Serializer serializer = new Persister();
        RecallMainController.getInstance().getOkHttpClient().newCall(request).enqueue(new Callback() {
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
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if(example==null){
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


    @OnClick(R.id.profile)
    public void profileBtnClick(View v) {
        Toast.makeText(getApplicationContext(),"profileBtn CLick",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), ProfileActivity.class);
        startActivity(intent);

    }
}
