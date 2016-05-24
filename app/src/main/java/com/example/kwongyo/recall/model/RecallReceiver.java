package com.example.kwongyo.recall.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import com.example.kwongyo.recall.model.DAO.MarkerDAO;

/**
 * Created by adminstrator on 2016-05-23.
 */
public class RecallReceiver  extends BroadcastReceiver {
    GpsInfo gpsInfo;
    public RecallReceiver(GpsInfo gpsInfo) {
        this.gpsInfo=gpsInfo;
    }
    public RecallReceiver(){

    }
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("RecallReceiver!방송발생!", intent.getAction());
        Log.e("location------",intent.getAction());
        if (gpsInfo.isGetLocation()) {
            Log.e("lat_lon",gpsInfo.getLatitude()+"_"+gpsInfo.getLongitude());
            MarkerDAO.getInstance(context).insertMarker(Double.toString(gpsInfo.getLatitude()), Double.toString(gpsInfo.getLongitude()));
        } else {
            //gpsInfo.showSettingsAlert();
        }

    }
}
