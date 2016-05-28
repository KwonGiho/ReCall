package com.example.kwongyo.recall;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.kwongyo.recall.adapter.ReCallAdapter;
import com.example.kwongyo.recall.core.RecallMainController;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by kwongyo on 2016-05-21.
 */
public class ProfileActivity extends AppCompatActivity{
    @Bind(R.id.profile_recyclerView)
    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;
    ReCallAdapter reCallAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);
        ButterKnife.bind(this);
        gridLayoutManager = new GridLayoutManager(this,3);

        recyclerView.setLayoutManager(gridLayoutManager);

        reCallAdapter = new ReCallAdapter(getApplicationContext(),null);

        recyclerView.setAdapter(reCallAdapter);

        RecallMainController.getInstance().setImage(this,reCallAdapter);


    }
}
