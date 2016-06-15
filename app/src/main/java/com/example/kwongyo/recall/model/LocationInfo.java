package com.example.kwongyo.recall.model;

/**
 * Created by kwongyo on 2016-05-24.
 *
 */

/**
 * 원래는 처음에 쓰려고 만들었지만 MarkerDTO로 대체됨.
 * 클래스 이름이 회색으로 변하면 삭제해도 될듯?
 */
public class LocationInfo {
    private int mid;
    private double lat;
    private double lon;
    private Long mTine;
    private String event;

    public LocationInfo() {
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

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public LocationInfo(int mid, double lat, double lon, Long mTine, String event) {

        this.mid = mid;
        this.lat = lat;
        this.lon = lon;
        this.mTine = mTine;
        this.event = event;
    }

    @Override
    public String toString() {
        return "LocationInfo{" +
                "mid=" + mid +
                ", lat=" + lat +
                ", lon=" + lon +
                ", mTine=" + mTine +
                ", event='" + event + '\'' +
                '}';
    }
}
