package com.example.buhat.detailVulkan;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.buhat.BD.Event;

public class DetailVulkanViewModel extends AndroidViewModel {
    private Event event;

    private MutableLiveData<Event> eventMutableLiveData = new  MutableLiveData<Event>();

    public LiveData<Event> getEventMutableLiveData() {
        return eventMutableLiveData;
    }

    public DetailVulkanViewModel(Event event, @NonNull Application application) {
        super(application);
        this.event = event;
        eventMutableLiveData.setValue(event);
    }

}
