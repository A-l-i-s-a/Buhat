package com.example.buhat.vulkan;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.buhat.BD.Bar;
import com.example.buhat.BD.Event;
import com.example.buhat.BD.User;
import com.example.buhat.R;
import com.example.buhat.network.Controller;
import com.example.buhat.network.VulkanApiService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class ListVulkanovFragment extends Fragment {

    List<Event> events = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_vulkanov, container, false);
        // Inflate the layout for this fragment
        final RecyclerView recyclerView = view.findViewById(R.id.recyclerViewVulkanov);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        events.add(new Event("eventName1", new Bar("barName", "barDescription", "address", 1, "http"), "address", 1, "dfjd dkj ddj dl djkfn kd djdlf dj nldf ", new User("db", "1111")));
        events.add(new Event("eventName2", new Bar("barName", "barDescription", "address", 1, "http"), "address", 2, "dfjd dkj ddj dl djkfn kd djdlf dj nldf ", new User("db", "1111")));
        events.add(new Event("eventName3", new Bar("barName", "barDescription", "address", 1, "http"), "address", 3, "dfjd dkj ddj dl djkfn kd djdlf dj nldf ", new User("db", "1111")));
        events.add(new Event("eventName4", new Bar("barName", "barDescription", "address", 1, "http"), "address", 4, "dfjd dkj ddj dl djkfn kd djdlf dj nldf ", new User("db", "1111")));
        events.add(new Event("eventName5", new Bar("barName", "barDescription", "address", 1, "http"), "address", 5, "dfjd dkj ddj dl djkfn kd djdlf dj nldf ", new User("db", "1111")));



        Adapter adapter = new Adapter(events, new Adapter.ViewHolder.Listener() {
            @Override
            public void onMovieClick(Event chat) {

            }
        });

        recyclerView.setAdapter(adapter);


        Controller ctrl = new Controller();
        ctrl.start();

        //String eventName, Bar bar, String address, int countPeople, String description, User eventCreator
        //String barName, String barDescription, String address, int averageСheck, String imageUrl


        Timber.i(" ctrl.getCall().enqueue(new Callback<List<Event>>()");

        ctrl.getCall().enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                Timber.i("response: %s", response.toString());
                events.addAll(response.body());
                Objects.requireNonNull(recyclerView.getAdapter()).notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {

            }
        });

        return view;
    }

}
