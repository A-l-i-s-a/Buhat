package com.example.buhat.network;

import com.example.buhat.BD.Bar;
import com.example.buhat.BD.Event;
import com.example.buhat.BD.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface ApiService {
    @GET("events/")
    Call<List<Event>> getListEvents();

    @GET("users/find/")
    Call<User> getUser(@Query("login") String login);

    @POST("events/add/")
    Call<Event> postData(@Body Event data);

    @POST("bars/add/")
    Call<Bar> addBar(@Body Bar bar);

    @GET("bars")
    Call<List<Bar>> getListBar();

}


