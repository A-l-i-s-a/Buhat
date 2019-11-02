package com.example.buhat.vulkan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buhat.BD.Event;
import com.example.buhat.R;
import com.example.buhat.network.App;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class ListVulkanovFragment extends Fragment {

    List<Event> events = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_list_vulkanov, container, false);
        // Inflate the layout for this fragment
        final RecyclerView recyclerView = view.findViewById(R.id.recyclerViewVulkanov);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        Adapter adapter = new Adapter(events, new Adapter.ViewHolder.Listener() {
            @Override
            public void onMovieClick(Event chat) {
                Navigation.findNavController(view).navigate(R.id.action_listVulkanovFragment_to_detailVulkanFragment);
            }
        });

        recyclerView.setAdapter(adapter);

        App.getApi().loadChanges().enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(@NotNull Call<List<Event>> call, @NotNull Response<List<Event>> response) {
                events.addAll(response.body());
                recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {
                Timber.i(t);
                Toast.makeText(getActivity(), "call.toString() = " + call.toString(), Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

}
