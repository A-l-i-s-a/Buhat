package com.example.buhat.BD;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Event implements Parcelable{

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
    @SerializedName("creator")
    @Expose
    private User eventCreator; //создатель эвента

    private Chat chat;

//    @SerializedName("imageUrl")
//    @Expose
//    private String imageUrl;

    private static long countEvent = 2;

    public Event(long id, String eventName, Bar bar, String address, int countPeople, String description, User eventCreator) {
        this.id = id;
        EventName = eventName;
        this.bar = bar;
        this.address = address;
        this.countPeople = countPeople;
        this.description = description;
        this.eventCreator = eventCreator;
    }

    public Event(String eventName, Bar bar, String address, int countPeople, String description, User eventCreator) {
        EventName = eventName;
        this.bar = bar;
        this.address = address;
        this.countPeople = countPeople;
        this.description = description;
        this.eventCreator = eventCreator;
    }

    public Event() {
    }

    public Event(String eventName, String address, int countPeople, String description, User eventCreator) {
        EventName = eventName;
        this.address = address;
        this.countPeople = countPeople;
        this.description = description;
        this.eventCreator = eventCreator;
    }

    protected Event(Parcel in) {
        id = in.readLong();
        EventName = in.readString();
        address = in.readString();
        countPeople = in.readInt();
        description = in.readString();
//        imageUrl = in.readString();
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

//    public String getImageUrl() {
//        return imageUrl;
//    }
//
//    public void setImageUrl(String imageUrl) {
//        this.imageUrl = imageUrl;
//    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(id);
        parcel.writeString(EventName);
        parcel.writeString(address);
        parcel.writeInt(countPeople);
        parcel.writeString(description);
//        parcel.writeString(imageUrl);
    }

    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", EventName='" + EventName + '\'' +
                ", bar=" + bar +
                ", address='" + address + '\'' +
                ", countPeople=" + countPeople +
                ", description='" + description + '\'' +
                ", eventCreator=" + eventCreator +
//                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}