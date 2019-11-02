package com.example.buhat.network;

import android.app.Application;

import com.example.buhat.BD.Event;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App {

    private static Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.113:8181/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


    public static VulkanApiService getApi() {
        return retrofit.create(VulkanApiService.class);
    }

}
