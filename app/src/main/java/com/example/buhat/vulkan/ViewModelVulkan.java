package com.example.buhat.vulkan;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.buhat.BD.Event;
import com.example.buhat.network.Repository;

import java.util.List;

public class ViewModelVulkan extends ViewModel {

    private MutableLiveData<List<Event>> mutableLiveData;

    public void init() {
        if (mutableLiveData != null) {
            return;
        }
        Repository repository = Repository.getInstance();
        mutableLiveData = repository.getListEvents();

    }

    public LiveData<List<Event>> getMutableLiveData() {
        return mutableLiveData;
    }


}
