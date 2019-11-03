package com.example.buhat.loginAndRegestration;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.buhat.BD.Event;
import com.example.buhat.BD.User;
import com.example.buhat.vulkan.VulkanRepository;

import java.util.List;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<User> mutableLiveData;
    private VulkanRepository vulkanRepository;

    public void init(String login) {
        if (mutableLiveData != null) {
            return;
        }
        vulkanRepository = VulkanRepository.getInstance();
        mutableLiveData = vulkanRepository.getUser(login);
    }

    public LiveData<User> getMutableLiveData() {
        return mutableLiveData;
    }

    public VulkanRepository getVulkanRepository() {
        return vulkanRepository;
    }
}
