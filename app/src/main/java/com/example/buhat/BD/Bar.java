package com.example.buhat.BD;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bar {
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("name")
    @Expose
    private String barName;
    @SerializedName("description")
    @Expose
    private String barDescription;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("averageСheck")
    @Expose
    private int averageСheck;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;

    public Bar(long id, String barName, String barDescription, String address, int averageСheck, String imageUrl) {
        this.id = id;
        this.barName = barName;
        this.barDescription = barDescription;
        this.address = address;
        this.averageСheck = averageСheck;
        this.imageUrl = imageUrl;
    }

    public Bar(String barName, String barDescription, String address, int averageСheck, String imageUrl) {
        this.barName = barName;
        this.barDescription = barDescription;
        this.address = address;
        this.averageСheck = averageСheck;
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getAverageСheck() {
        return averageСheck;
    }

    public void setAverageСheck(int averageСheck) {
        this.averageСheck = averageСheck;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBarName() {
        return barName;
    }

    public void setBarName(String barName) {
        this.barName = barName;
    }

    public String getBarDescription() {
        return barDescription;
    }

    public void setBarDescription(String barDescription) {
        this.barDescription = barDescription;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Bar{" +
                "id=" + id +
                ", barName='" + barName + '\'' +
                ", barDescription='" + barDescription + '\'' +
                ", address='" + address + '\'' +
                ", averageСheck=" + averageСheck +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
