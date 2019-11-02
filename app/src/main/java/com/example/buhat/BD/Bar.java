package com.example.buhat.BD;

public class Bar {
    private long id;
    private String barName;
    private String barDescription;
    private String address;
    private int averageСheck;
    private String imageUrl;
    private static long countBar = 1;

    public Bar(long id, String barName, String barDescription, String address, int averageСheck, String imageUrl) {
        this.id = id;
        this.barName = barName;
        this.barDescription = barDescription;
        this.address = address;
        this.averageСheck = averageСheck;
        this.imageUrl = imageUrl;
        countBar++;
    }

    public Bar(String barName, String barDescription, String address, int averageСheck, String imageUrl) {
        this.id =countBar;
        this.barName = barName;
        this.barDescription = barDescription;
        this.address = address;
        this.averageСheck = averageСheck;
        this.imageUrl = imageUrl;
        countBar++;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public static long getCountBar() {
        return countBar;
    }

    public static void setCountBar(long countBar) {
        Bar.countBar = countBar;
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
}
