package com.example.buhat.network;

import com.example.buhat.BD.Event;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;
//
//public class Controller implements Callback<List<Event>> {
//
//    static final String BASE_URL = "http://localhost:8181";
//
//    Call<List<Event>> call;
//
//    public void start() {
//        Gson gson = new GsonBuilder()
//                .setLenient()
//                .create();
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .build();
//
//        VulkanApiService gerritAPI = retrofit.create(VulkanApiService.class);
//
//        call = gerritAPI.getListEvents();
//        Timber.i(" Call<List<Event>> ");
//
//    }
//
//    public  Call<List<Event>> getCall() {
//        return call;
//    }
//
//
//    @Override
//    public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
//        Timber.i("onResponse: response.isSuccessful() = %s", response.isSuccessful());
//        if (response.isSuccessful()) {
//            List<Event> changesList = response.body();
//            Timber.i("onResponse %s", changesList.size());
//            for (Event event : changesList) {
//                System.out.println(event.getEventName());
//            }
//        } else {
//            System.out.println(response.errorBody());
//        }
//
//    }
//
//    @Override
//    public void onFailure(Call<List<Event>> call, Throwable t) {
//        t.printStackTrace();
//    }
//}
