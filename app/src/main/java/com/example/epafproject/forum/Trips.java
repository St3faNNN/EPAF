package com.example.epafproject.forum;

public class Trips {
    String lat;
    String lon;
    String sendFrom;
    String title;
    String encodedImg;
    String description;

    public Trips(String lat, String lon, String sendFrom, String title, String encodedImg, String description) {
        this.lat = lat;
        this.lon = lon;
        this.sendFrom = sendFrom;
        this.title = title;
        this.encodedImg = encodedImg;
        this.description = description;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getSendFrom() {
        return sendFrom;
    }

    public void setSendFrom(String sendFrom) {
        this.sendFrom = sendFrom;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEncodedImg() {
        return encodedImg;
    }

    public void setEncodedImg(String encodedImg) {
        this.encodedImg = encodedImg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
