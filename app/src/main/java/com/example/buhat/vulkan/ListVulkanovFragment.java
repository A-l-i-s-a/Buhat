package com.example.buhat.vulkan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buhat.BD.Event;
import com.example.buhat.R;
import com.example.buhat.detailVulkan.DetailVulkanFragment;
import com.example.buhat.detailVulkan.DetailVulkanViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

public class ListVulkanovFragment extends Fragment {

    List<Event> events = new ArrayList<>();
    ViewModelVulkan viewModelVulkan;
    Adapter adapter;
    View view;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_list_vulkanov, container, false);
        // Inflate the layout for this fragment
        recyclerView = view.findViewById(R.id.recyclerViewVulkanov);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(events, new Adapter.ViewHolder.Listener() {
            @Override
            public void onMovieClick(Event chat) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("event", chat);
                System.out.println(chat.getImageUrl());
                Navigation.findNavController(view).navigate(R.id.action_listVulkanovFragment_to_detailVulkanFragment, bundle);
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(true);
        viewModelVulkan = ViewModelProviders.of(this).get(ViewModelVulkan.class);
        viewModelVulkan.init();

        setupRecyclerView();

        FloatingActionButton fab = view.findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_listVulkanovFragment_to_addFragment);
            }
        });

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
