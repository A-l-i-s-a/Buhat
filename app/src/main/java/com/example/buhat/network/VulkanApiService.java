package com.example.buhat.network;

import com.example.buhat.BD.Event;
import com.example.buhat.BD.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface VulkanApiService {
    @GET("events/")
    Call<List<Event>> getListEvents();

    @GET("users/find/")
    Call<User> getUser(@Query("login") String login);

}


