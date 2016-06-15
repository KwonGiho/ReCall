package com.example.kwongyo.recall;

import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kwongyo.recall.adapter.LocationListAdapter;
import com.example.kwongyo.recall.adapter.ReCallAdapter;
import com.example.kwongyo.recall.core.ProfileController;
import com.example.kwongyo.recall.core.RecallMainController;
import com.example.kwongyo.recall.model.CustomPreference;
import com.example.kwongyo.recall.model.DAO.MarkerDAO;
import com.example.kwongyo.recall.model.DTO.MarkerDTO;
import com.example.kwongyo.recall.model.LocationInfo;
import com.example.kwongyo.recall.model.MarkerJson;

import org.json.JSONObject;

import java.util.ArrayList;
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
    @Bind(R.id.profile_name)
    TextView profileName;

    @Bind(R.id.toServer)
    Button toServer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);
        ButterKnife.bind(this);
        showAsThumnail();

        CustomPreference customPreference = CustomPreference.getInstance(getApplicationContext());
        profileName.setText(customPreference.getValue("name","name"));



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

    List<LocationInfo> locationInfoList;
    @OnClick(R.id.showAsList)
    public void showAsListClick(View v) {
        linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(linearLayoutManager);

        locationListAdapter = new LocationListAdapter(getApplicationContext(),null);

        recyclerView.setAdapter(locationListAdapter);

        locationInfoList = MarkerDAO.getInstance(getApplicationContext()).searchLocationInfo();

        for(LocationInfo locationInfo : locationInfoList)
            locationListAdapter.add(locationInfo);

        toServer.setVisibility(View.VISIBLE);

    }

    ProfileController profileController;
    CustomPreference customPreference;
    @OnClick(R.id.toServer)
    public void showBtn(View v) {
        List<MarkerDTO> markerDtos = new ArrayList<MarkerDTO>();
        customPreference = CustomPreference.getInstance(getApplicationContext());
        for(LocationInfo locationInfo : locationInfoList) {
            MarkerDTO markerDTO = new MarkerDTO();
            markerDTO.setLat(Double.toString(locationInfo.getLat()));
            markerDTO.setLng(Double.toString(locationInfo.getLon()));
            markerDTO.setM_time(Long.toString(locationInfo.getmTine()));
            markerDTO.setEvent(locationInfo.getEvent());
            markerDtos.add(markerDTO);
        }
        //JSONArra
        profileController = ProfileController.getInstance();

        JSONObject jsonObject = MarkerJson.getInstance().createJson(markerDtos);
        String markers = jsonObject.toString();
        profileController.sendMarker(getApplicationContext(),markers);
    }
}
