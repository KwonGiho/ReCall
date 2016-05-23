package com.example.kwongyo.recall.model;


import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by adminstrator on 2016-05-23.
 */
public class LocationService extends Service{
    private LocationManager locationManager;
    private boolean isGPSEnabled = false;
    private boolean isNetworkEnabled = false;


    @Override
    public IBinder onBind(final Intent intent) {
        return null;
    }
    @Override
    public void onCreate(){
        super.onCreate();

        locationManager = (LocationManager)getSystemService(LOCATION_SERVICE);
        isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER); // GPS 이용
        isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER); // network 이용가능여부
        Log.d("RecallReceiver","여긴온다");
        if( !isGPSEnabled && !isNetworkEnabled) {
            Log.d("LocationManager","noting is enabled");
            return ;
        }

        if(isGPSEnabled) // gps를 이용한 측위 요청
        {
            try {
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,
                        locationListenerGps);
            }catch(SecurityException e) {
                e.printStackTrace();
            }
        }
        if(isNetworkEnabled) {//Network를 이용한 측위요청
            try {
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListenerNetwork);// 현재 위치 업데이트
            } catch(SecurityException e) {
                e.printStackTrace();
            }
        }
    }
    /*------------------------------------------------------이 아래부턴 리스너들------------------------------------------------------------------*/
    private LocationListener locationListenerGps = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            double x = location.getLatitude();
            double y = location.getLongitude();
            Log.d("x_y",x+"_"+y);

            try {
                locationManager.removeUpdates(this);
                locationManager.removeUpdates(locationListenerNetwork);
            }catch(SecurityException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };
    LocationListener locationListenerNetwork = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            double x = location.getLatitude();
            double y = location.getLongitude();
            Log.d("x_y",x+"_"+y);
            try {
                locationManager.removeUpdates(this);
                locationManager.removeUpdates(locationListenerGps);
            }catch(SecurityException e) {
                e.printStackTrace();
            }


        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };
}
