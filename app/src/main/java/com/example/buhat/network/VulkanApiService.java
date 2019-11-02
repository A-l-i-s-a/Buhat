package com.example.buhat.network;

import com.example.buhat.BD.Event;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface VulkanApiService {
    @GET("bars/")
    Call<List<Event>> getListEvents();

}


