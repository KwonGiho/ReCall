package com.example.kwongyo.recall.model;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by kwongyo on 2016-05-24.
 * ServiceReceiver의 줄여서 ServiceR.
 * 15분마다 위치저장/사진찍기 핸드폰켜지기 전화걸기 등등 모든타이밍에 위지정보를 남기는 서비스.
 */
public class ServiceR extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("ServiceR","onBind()");
        return null;
    }



    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("ServiceR", "onCreate()");
        GpsInfo gpsInfo = new GpsInfo(this);
        RecallReceiver recallReceiver = new RecallReceiver(gpsInfo);
        registerReceiver(recallReceiver,new IntentFilter(Intent.ACTION_BATTERY_LOW)); // 배터리의 잔여 용량이 낮을 때
        registerReceiver(recallReceiver, new IntentFilter(Intent.ACTION_BOOT_COMPLETED)); // 부팅이 완료될 때
        registerReceiver(recallReceiver, new IntentFilter(Intent.ACTION_CAMERA_BUTTON)); // 카메라 버튼이 눌릴 때
        registerReceiver(recallReceiver, new IntentFilter(Intent.ACTION_MEDIA_BUTTON)); // 미디어 버튼이 눌릴 때
        registerReceiver(recallReceiver, new IntentFilter(Intent.ACTION_CALL_BUTTON)); // 이건 전화버튼이 눌릴 때?
        registerReceiver(recallReceiver, new IntentFilter(Intent.ACTION_NEW_OUTGOING_CALL)); // 통화를 발신하려고 할때
        registerReceiver(recallReceiver, new IntentFilter(Intent.ACTION_LOCALE_CHANGED)); // 지역 설정이 바뀔때
        registerReceiver(recallReceiver, new IntentFilter(Intent.ACTION_POWER_CONNECTED)); // 외부 전원을 기기와 연결할 때
        registerReceiver(recallReceiver,new IntentFilter(Intent.ACTION_SCREEN_ON));
        registerReceiver(recallReceiver,new IntentFilter(Intent.ACTION_SCREEN_OFF));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}