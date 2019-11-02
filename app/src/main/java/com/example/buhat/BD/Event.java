package com.example.buhat.BD;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Event {


    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("name")
    @Expose
    private String EventName;//название

    private Bar bar;//ссылка на бар
    @SerializedName("address")
    @Expose
    private String address;//адрес бара

    private int countPeople;// кол-во участников
    @SerializedName("description")
    @Expose
    private String description;// описание

    private User eventCreator; //создатель эвента

    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;

    private static long countEvent = 1;

    public Event(long id, String eventName, Bar bar, String address, int countPeople, String description, User eventCreator) {
        this.id = id;
        EventName = eventName;
        this.bar = bar;
        this.address = address;
        this.countPeople = countPeople;
        this.description = description;
        this.eventCreator = eventCreator;
        countEvent++;
    }

    public Event(String eventName, Bar bar, String address, int countPeople, String description, User eventCreator) {
        this.id = countEvent;
        EventName = eventName;
        this.bar = bar;
        this.address = address;
        this.countPeople = countPeople;
        this.description = description;
        this.eventCreator = eventCreator;
        countEvent++;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    public Bar getBar() {
        return bar;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCountPeople() {
        return countPeople;
    }

    public void setCountPeople(int countPeople) {
        this.countPeople = countPeople;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getEventCreator() {
        return eventCreator;
    }

    public void setEventCreator(User eventCreator) {
        this.eventCreator = eventCreator;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}