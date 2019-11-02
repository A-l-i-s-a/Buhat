package com.example.buhat.network;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {
    private static VulkanApiService vulkanApiService;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.113:8181/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        vulkanApiService = retrofit.create(VulkanApiService.class);
    }

    public static VulkanApiService getApi() {
        return vulkanApiService;
    }
}
