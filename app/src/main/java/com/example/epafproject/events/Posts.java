package com.example.epafproject.events;

public class Posts {

    private int idNo;

    String lat;
    String lon;
    String description;
    String encodedImg;

    public Posts(int idNo, String lat, String lon, String description, String encodedImg) {
        this.idNo = idNo;
        this.lat = lat;
        this.lon = lon;
        this.description = description;
        this.encodedImg = encodedImg;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEncodedImg() {
        return encodedImg;
    }

    public void setEncodedimg(String encodedimg) {
        this.encodedImg = encodedImg;
    }

    public int getIdNo() {
        return idNo;
    }

    public void setId(int idNo) {
        this.idNo = idNo;
    }
}