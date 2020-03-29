package com.example.buhat.BD;

import com.example.buhat.BD.Msg;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Calendar;
import java.util.List;

public class Chat {
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("color")
    @Expose
    private int color;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("lastMsg")
    @Expose
    private String lastMsg;
    @SerializedName("lastDate")
    @Expose
    private Calendar lastDate;
    @SerializedName("count")
    @Expose
    private int count;
    private List<Msg> msgs;

    public Chat(int color, String name, List<Msg> msgs) {
        this.color = color;
        this.name = name;
        this.msgs = msgs;
        this.count = msgs.size();
        this.lastMsg = msgs.get(msgs.size() - 1).getMsg();
        this.lastDate = msgs.get(msgs.size() - 1).getDate();
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Msg> getMsgs() {
        return msgs;
    }

    public void setMsgs(List<Msg> msgs) {
        this.msgs = msgs;
    }

    public String getLastMsg() {
        return lastMsg;
    }

    public Calendar getLastDate() {
        return lastDate;
    }

    public int getCount() {
        return msgs.size();
    }

    @Override
    public String toString() {
        return "Chat{" +
                "color=" + color +
                ", name='" + name + '\'' +
                ", lastMsg='" + lastMsg + '\'' +
                ", lastDate=" + lastDate +
                ", count=" + count +
                ", msgs=" + msgs +
                '}';
    }
}
