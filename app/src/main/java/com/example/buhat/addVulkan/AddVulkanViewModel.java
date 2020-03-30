package com.example.buhat.addVulkan;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.buhat.BD.Bar;
import com.example.buhat.BD.Event;
import com.example.buhat.network.DataRepository;

import java.util.List;

public class AddVulkanViewModel extends ViewModel {
    private MutableLiveData<List<Bar>> mutableLiveData;
    private DataRepository dataRepository;
    public void init() {
        if (mutableLiveData != null) {
            return;
        }
        dataRepository = DataRepository.getInstance();
        mutableLiveData = dataRepository.getListBar();
    }

    public LiveData<List<Bar>> getMutableLiveData() {
        return mutableLiveData;
    }

    public void postEvent(Event event) {
        dataRepository.postEvent(event);
    }
}
