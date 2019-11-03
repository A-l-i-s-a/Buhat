package com.example.buhat.chat;

import java.util.Calendar;
import java.util.List;

public class Chat {
    private int color;
    private String name;
    private String lastMsg;
    private Calendar lastDate;
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
