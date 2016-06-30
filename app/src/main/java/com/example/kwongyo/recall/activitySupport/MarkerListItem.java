package com.example.kwongyo.recall.activitySupport;

/**
 * Created by Daesub on 2016-06-30.
 */
public class MarkerListItem {

    private String imgUrl;
    private String event;
    private String city;
    private String date;

    public MarkerListItem () {
        this(null, null, null, null);
    }

    public MarkerListItem(String imgUrl, String event, String city, String date ) {
        this.imgUrl = imgUrl;
        this.event = event;
        this.city = city;
        this.date = date;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "MarkerListItem{" +
                "imgUrl='" + imgUrl + '\'' +
                ", event='" + event + '\'' +
                ", city='" + city + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
