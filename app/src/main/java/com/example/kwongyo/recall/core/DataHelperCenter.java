package com.example.kwongyo.recall.core;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kwongyo on 2016-05-23.
 */
public class DataHelperCenter extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="RECALL.db";
    private static final String MARKER_TABLE ="marker";
    private static final int DATABASE_VERSION=1;

    private static final String CREATE_MARKER_TABLE=
            "CREATE TABLE "+MARKER_TABLE+
                    " (m_id integer autoincrement primary key," +
                    "address text not null," +
                    "lat double not null" +
                    "lng double not null";

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
