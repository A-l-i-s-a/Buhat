package com.example.buhat.BD;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Calendar;

public class Msg {
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("date")
    @Expose
    private Calendar date;

    public Msg(String name, String msg, Calendar date) {
        this.name = name;
        this.msg = msg;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "name='" + name + '\'' +
                ", msg='" + msg + '\'' +
                ", date=" + date +
                '}';
    }
}
