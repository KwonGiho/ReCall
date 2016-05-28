package com.example.kwongyo.recall.model.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.util.Log;

import com.example.kwongyo.recall.core.DataHelperCenter;
import com.example.kwongyo.recall.model.LocationInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kwongyo on 2016-05-24.
 */
public class MarkerDAO {

    static class Columns {
        static final String M_ID="m_id";
        static final String LAT="lat";
        static final String LON="lon";
    }
    private static MarkerDAO markerDAO;
    private static final String MARKER_TABLE ="marker_table";
    private static DataHelperCenter dataHelperCenter;

    static {
        markerDAO = new MarkerDAO();
    }

    private MarkerDAO() {}

    public static MarkerDAO getInstance() {
        return markerDAO;
    }

    public static MarkerDAO getInstance(Context context) {
        dataHelperCenter = DataHelperCenter.getInstance(context);
        return markerDAO;
    }

    public boolean insertMarker(String lat,String lon) {
        SQLiteDatabase db = dataHelperCenter.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        Log.e("insertMarker",lat+"_"+lon);
        contentValues.put(Columns.LAT,lat);
        contentValues.put(Columns.LON,lon);

        long result = db.insert(MARKER_TABLE,null,contentValues);

        if(result == -1)
            return false;
        return true;
    }
    public ArrayList<LocationInfo> searchLocationInfo() {
        ArrayList<LocationInfo> arrayList = new ArrayList<LocationInfo>();
        SQLiteDatabase db = dataHelperCenter.getReadableDatabase();
        String sql = "select * from "+MARKER_TABLE;
        Cursor cursor = null;
        cursor = db.rawQuery(sql,null);
        while( cursor.moveToNext() ) {
            arrayList.add(new LocationInfo( cursor.getDouble(1), cursor.getDouble(2) ) );
        }
        cursor.close();
        return arrayList;
    }

}
