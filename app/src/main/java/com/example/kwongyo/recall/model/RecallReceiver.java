package com.example.kwongyo.recall.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.FileObserver;
import android.util.Log;
import android.widget.Toast;

import com.example.kwongyo.recall.model.DAO.MarkerDAO;

/**
 * Created by adminstrator on 2016-05-23.
 */
public class RecallReceiver  extends BroadcastReceiver {

    // File Observing 클래스
    public static FileObserver observer;

    public static GpsInfo gpsInfo;

    final static String pathToWatch = android.os.Environment.getExternalStorageDirectory().toString() + "/DCIM/Camera/";

    public static Context mContext;
    public RecallReceiver(GpsInfo gpsInfo) {
        this.gpsInfo=gpsInfo;
    }
    public RecallReceiver(){
    }
    @Override
    public void onReceive(Context context, Intent intent) {


        Log.e("RecallReceiver!방송발생!", intent.getAction());
        Log.e("location------", intent.getAction());

        // /DCMI/Camera 폴더에 새로운 Medie 파일이 저장되었는지 체크
        mContext = context;
        startWatching();
        //isGetLocation(intent.getAction());//버츄얼 디바이스에서 돌릴땐 이걸 수정해야 함.
        //여기는 다른 Thread에서 돌려야 할듯....




    }
    static boolean isGetLocation(String event){
        if (gpsInfo.isGetLocation()) {
            Log.e("lat_lon",gpsInfo.getLatitude()+"_"+gpsInfo.getLongitude());
            MarkerDAO.getInstance(mContext).insertMarker(Double.toString(gpsInfo.getLatitude()), Double.toString(gpsInfo.getLongitude()),event);
        } else {
            //gpsInfo.showSettingsAlert();
        }
        return true;
    }
    /**
     *  /DCMI/Camera 폴더에 새로운 Medie 파일이 저장되었는지 체크하는 메소드
     */
    private void startWatching() {


        observer = new FileObserver(pathToWatch, FileObserver.CLOSE_WRITE) { // set up a file observer to watch this directory on sd card
            @Override
            public void onEvent(int event, final String file) {
                if (!file.equals(".probe")) { // check that it's not equal to .probe because thats created every time camera is launched
                    Log.e("Media 저장 : ", "FileName [" + pathToWatch + file + "]");
                }
            }
        };
        observer.startWatching();
    }
}
