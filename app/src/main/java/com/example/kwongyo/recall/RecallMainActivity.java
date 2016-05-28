package com.example.kwongyo.recall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.kwongyo.recall.adapter.ReCallAdapter;
import com.example.kwongyo.recall.core.RecallMainController;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

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

        recyclerView.setLayoutManager(gridLayoutManager);

        reCallAdapter = new ReCallAdapter(getApplicationContext(),null);

        recyclerView.setAdapter(reCallAdapter);

        RecallMainController.getInstance().setImage(this,reCallAdapter);
    }


    @OnClick(R.id.profile)
    public void profileBtnClick(View v) {
        Toast.makeText(getApplicationContext(),"profileBtn CLick",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), ProfileActivity.class);
        startActivity(intent);

    }


}
