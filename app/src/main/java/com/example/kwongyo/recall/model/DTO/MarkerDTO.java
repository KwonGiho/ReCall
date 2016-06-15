package com.example.kwongyo.recall.model.DTO;

import java.io.Serializable;

/**
 * Created by kwongyo on 2016-05-29.
 */
public class MarkerDTO implements Serializable{
    private String mId;
    private String uId;
    private String address;
    private String lat;
    private String lng;
    private String m_time;
    private String event;
    public MarkerDTO() {
    }

    public MarkerDTO(String mId, String uId, String address, String lat, String lng, String m_time, String event) {
        this.mId = mId;
        this.uId = uId;
        this.address = address;
        this.lat = lat;
        this.lng = lng;
        this.m_time = m_time;
        this.event = event;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getM_time() {
        return m_time;
    }

    public void setM_time(String m_time) {
        this.m_time = m_time;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "MarkerDTO{" +
                "mId='" + mId + '\'' +
                ", uId='" + uId + '\'' +
                ", address='" + address + '\'' +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                ", m_time='" + m_time + '\'' +
                ", event='" + event + '\'' +
                '}';
    }
}
