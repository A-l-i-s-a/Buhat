package com.example.buhat.vulkan;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.buhat.BD.Event;
import com.example.buhat.BD.User;

import java.util.List;

public class ViewModelVulkan extends ViewModel {

    private MutableLiveData<List<Event>> mutableLiveData;
    private VulkanRepository vulkanRepository;

    public void init() {
        if (mutableLiveData != null) {
            return;
        }
        vulkanRepository = VulkanRepository.getInstance();
        mutableLiveData = vulkanRepository.getListEvents();
    }

    public LiveData<List<Event>> getMutableLiveData() {
        return mutableLiveData;
    }


}
