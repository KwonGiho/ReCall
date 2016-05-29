package com.example.kwongyo.recall;

import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.kwongyo.recall.adapter.LocationListAdapter;
import com.example.kwongyo.recall.adapter.ReCallAdapter;
import com.example.kwongyo.recall.core.RecallMainController;
import com.example.kwongyo.recall.model.DAO.MarkerDAO;
import com.example.kwongyo.recall.model.LocationInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
        showAsThumnail();
    }
    public void showAsThumnail(){
        gridLayoutManager = new GridLayoutManager(this,3);

        recyclerView.setLayoutManager(gridLayoutManager);

        reCallAdapter = new ReCallAdapter(getApplicationContext(),null);

        recyclerView.setAdapter(reCallAdapter);

        RecallMainController.getInstance().setImage(this, reCallAdapter);
    }
    @OnClick(R.id.showAsThumnail)
    public void showAsThumnailClick(View v) {
        showAsThumnail();
    }
    LinearLayoutManager linearLayoutManager;
    LocationListAdapter locationListAdapter;
    @OnClick(R.id.showAsList)
    public void showAsListClick(View v) {
        linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(linearLayoutManager);

        locationListAdapter = new LocationListAdapter(getApplicationContext(),null);

        recyclerView.setAdapter(locationListAdapter);

        List<LocationInfo> locationInfoList = MarkerDAO.getInstance(getApplicationContext()).searchLocationInfo();

        for(LocationInfo locationInfo : locationInfoList)
            locationListAdapter.add(locationInfo);

    }
}
