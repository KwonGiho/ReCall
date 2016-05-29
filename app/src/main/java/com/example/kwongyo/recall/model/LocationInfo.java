package com.example.kwongyo.recall.model;

/**
 * Created by kwongyo on 2016-05-24.
 *
 */
public class LocationInfo {
    private int mid;
    private double lat;
    private double lon;
    private Long mTine;

    public LocationInfo() {
    }

    public LocationInfo(int mid, double lat, double lon, Long mTine) {
        this.mid = mid;
        this.lat = lat;
        this.lon = lon;
        this.mTine = mTine;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public Long getmTine() {
        return mTine;
    }

    public void setmTine(Long mTine) {
        this.mTine = mTine;
    }

    @Override
    public String toString() {
        return "LocationInfo{" +
                "mid=" + mid +
                ", lat=" + lat +
                ", lon=" + lon +
                ", mTine=" + mTine +
                '}';
    }
}
