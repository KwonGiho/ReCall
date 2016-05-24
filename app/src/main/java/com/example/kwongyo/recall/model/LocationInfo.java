package com.example.kwongyo.recall.model;

/**
 * Created by kwongyo on 2016-05-24.
 *
 */
public class LocationInfo {
    private double lat;
    private double lon;
    public LocationInfo(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "LocationInfo{" +
                "lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
