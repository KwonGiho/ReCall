package com.example.kwongyo.recall.core;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.kwongyo.recall.model.RecallReceiver;

/**
 * Created by kwongyo on 2016-05-23.
 */
public class DataHelperCenter extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="RECALL.db";
    private static final String MARKER_TABLE ="marker_table";
    private static final int DATABASE_VERSION=1;

    private static final String CREATE_MARKER_TABLE=
            "CREATE TABLE "+MARKER_TABLE+
                    " (m_id integer primary key AUTOINCREMENT," +
                    "lat TEXT not null," +
                    "lon TEXT not null," +
                    "m_time varchar(100)," +
                    "event varchar(200) );";

    private Context context;
    private DataHelperCenter(Context context){
       super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.context=context;
    }

    private static DataHelperCenter dataHelperCenter;
    public static DataHelperCenter getInstance(Context context) {
        if(dataHelperCenter == null)
            dataHelperCenter = new DataHelperCenter(context);
        return dataHelperCenter;
    }
    public static DataHelperCenter getInstance() {
        return dataHelperCenter;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_MARKER_TABLE);
        /*--앱 다운로드 후 한번만 실행될 Broadcast 부분--*/
        /* 템플릿
        context.registerReceiver();
        context.registerReceiver(recallReceiver,new IntentFilter());
        */

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /*새로운 버전이 아닐경우.*/
        if(oldVersion > newVersion)
            return ;
        db.execSQL("DROP TABLE IF EXISTS"+MARKER_TABLE);
        onCreate(db);
    }
}
