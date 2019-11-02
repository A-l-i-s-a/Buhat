package com.example.buhat.vulkan;

import android.speech.RecognitionService;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.buhat.BD.Event;
import com.example.buhat.network.App;
import com.example.buhat.network.VulkanApiService;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class VulkanRepository {
    private static VulkanRepository vulkanRepository;

    public static VulkanRepository getInstance(){
        if (vulkanRepository == null) {
            vulkanRepository = new VulkanRepository();
        }
        return vulkanRepository;
    }

    private VulkanApiService apiService;

    public VulkanRepository() {
        apiService = App.getApi();
    }


    public MutableLiveData<List<Event>> getListEvents() {
        MutableLiveData<List<Event>> newEvents = new MutableLiveData<>();
        apiService.getListEvents().enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(@NotNull Call<List<Event>> call, @NotNull Response<List<Event>> response) {
                if (response.isSuccessful()) {
                    newEvents.setValue(response.body());
                    Timber.i(" onResponse");
                }
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {
                newEvents.setValue(null);
                Timber.i(t);
            }
        });
        return newEvents;
    }
}
