package com.example.buhat.vulkan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buhat.BD.Event;
import com.example.buhat.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

public class ListVulkanovFragment extends Fragment {

    List<Event> events = new ArrayList<>();
    ViewModelVulkan viewModelVulkan;
    Adapter adapter;
    View view;
    RecyclerView recyclerView;
    Bundle bundle;
    Event newEvent = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_list_vulkanov, container, false);
        // Inflate the layout for this fragment
        recyclerView = view.findViewById(R.id.recyclerViewVulkanov);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        bundle = getArguments();
        if (bundle == null) {
            bundle = new Bundle();
        } else {
            newEvent = bundle.getParcelable("newevent");
        }

        adapter = new Adapter(events, chat -> {
            bundle.putParcelable("event", chat);
            System.out.println(chat.getImageUrl());
            Navigation.findNavController(view).navigate(R.id.action_listVulkanovFragment_to_detailVulkanFragment, bundle);
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(true);
        viewModelVulkan = ViewModelProviders.of(this).get(ViewModelVulkan.class);
        viewModelVulkan.init();

        setupRecyclerView();

        FloatingActionButton fab = view.findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(view -> {
                bundle.putParcelable("event", events.get(0));
                Navigation.findNavController(view)
                        .navigate(R.id.action_listVulkanovFragment_to_addFragment, bundle);});

        if (newEvent != null) {
            events.add(newEvent);
            adapter.notifyDataSetChanged();
        }
        return view;
    }

    private void setupRecyclerView() {
        events.clear();
        viewModelVulkan.getMutableLiveData().observe(this, list -> {
            events.addAll(list);
            Timber.i("events.addAll(list)");
            adapter.notifyDataSetChanged();
        });
        adapter.notifyDataSetChanged();

    }

}
