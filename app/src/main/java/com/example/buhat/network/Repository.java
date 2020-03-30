package com.example.buhat.network;

import androidx.lifecycle.MutableLiveData;

import com.example.buhat.BD.Bar;
import com.example.buhat.BD.Event;
import com.example.buhat.BD.User;

import java.util.List;

public interface Repository {

    MutableLiveData<List<Event>> getListEvents();

    MutableLiveData<User> getUser(String login);

    MutableLiveData<List<Bar>> getListBar();

    void postEvent(Event event);
}
