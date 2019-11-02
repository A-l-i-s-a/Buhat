package com.example.buhat.vulkan;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.buhat.BD.Event;

import java.util.List;

public class ViewModelVulkan extends ViewModel {

    private MutableLiveData<List<Event>> mutableLiveData = new MutableLiveData<>();

    public LiveData<List<Event>> getMutableLiveData() {
        return mutableLiveData;
    }



}
