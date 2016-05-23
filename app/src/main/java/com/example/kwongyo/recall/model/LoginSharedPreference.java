package com.example.kwongyo.recall.model;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by kwongyo on 2016-05-22.
 */
public class LoginSharedPreference {
    public boolean savedUserName(Context context , String userName ) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("hett",context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("userName",userName);
        editor.commit();
        return true;
    }

    /**
     * userCode는 서버에서 보내는 uId( 유저의 primary key!)
     * @param context
     * @param userCode userCode
     * @return
     */
    public boolean savedUserCode(Context context , String userCode ) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("hett",context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("userCode",userCode);
        editor.commit();
        return true;
    }
    public boolean savedUserEmail(Context context , String userEmail ) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("hett",context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("userEmail",userEmail);
        editor.commit();
        return true;
    }
    /*여기 위까지만 작성함 아래는 수정해아함.*/
    /*public String searchHattFriendName(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("hett",context.MODE_PRIVATE);
        return sharedPreferences.getString("hattFriendName","Hatti");// 호출하는 키에 대응하는 값이 없을 경우 디폴트(Hatti)가 return됨.
    }
    public void updatePushAlarm(Context context,boolean isPushAlarm) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("hett",context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("pushAlarm",isPushAlarm);
        editor.commit();
    }
    public boolean searchPushAlarm(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("hett",context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("pushAlarm",true);
    }
    public void updateBellMode(Context context,boolean bellMode) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("hett",context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("bellMode",bellMode);
        editor.commit();
    }
    public boolean searchBellMode(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("hett",context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("bellMode",true);
    }
    public int searchLastUpdateDay(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("hett",context.MODE_PRIVATE);
        return sharedPreferences.getInt("lastUpdateDay", 0);
    }
    public boolean updateLastUpdateDay(Context context,int day) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("hett",context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("lastUpdateDay",day);
        return true;
    }*/
}
