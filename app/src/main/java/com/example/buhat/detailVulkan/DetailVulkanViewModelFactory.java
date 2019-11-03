package com.example.buhat.detailVulkan;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.buhat.BD.Event;

public class DetailVulkanViewModelFactory implements ViewModelProvider.Factory {
    private Event event;
    private Application application;

    public DetailVulkanViewModelFactory(Event event, Application application) {
        this.event = event;
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(DetailVulkanViewModel.class)) {
            return (T) new  DetailVulkanViewModel(event, application);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
