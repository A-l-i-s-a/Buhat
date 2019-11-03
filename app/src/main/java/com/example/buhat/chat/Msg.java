package com.example.buhat.chat;

import java.util.Calendar;

public class Msg {
    private String name;
    private String msg;
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
