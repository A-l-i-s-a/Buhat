package com.example.buhat.vulkan;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.buhat.BD.Event;
import com.example.buhat.network.DataRepository;

import java.util.List;

public class ViewModelVulkan extends ViewModel {

    private MutableLiveData<List<Event>> mutableLiveData;

    public void init() {
        if (mutableLiveData != null) {
            return;
        }
        DataRepository dataRepository = DataRepository.getInstance();
        mutableLiveData = dataRepository.getListEvents();

    }

    public LiveData<List<Event>> getMutableLiveData() {
        return mutableLiveData;
    }


}
