package com.example.buhat.addVulkan;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.buhat.BD.Bar;
import com.example.buhat.BD.Event;
import com.example.buhat.BD.User;
import com.example.buhat.R;

import java.util.Objects;

import timber.log.Timber;


public class AddFragment extends Fragment {

    private AddVulkanViewModel addVulkanViewModel;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add, container, false);

        EditText editTextNewName = view.findViewById(R.id.editTextNewName);
        EditText editTextNewAddress = view.findViewById(R.id.editTextNewAddress);
        EditText editTextDescription = view.findViewById(R.id.editTextDescription);
        EditText editTextAverageCheck = view.findViewById(R.id.editTextAverageCheck);
        Spinner spinner = view.findViewById(R.id.spinner);

        addVulkanViewModel = ViewModelProviders.of(this).get(AddVulkanViewModel.class);
        addVulkanViewModel.init();

        addVulkanViewModel.getMutableLiveData().observe(this, bars -> {
            ArrayAdapter<Bar> adapter = new ArrayAdapter<Bar>(Objects.requireNonNull(getContext()),
                    android.R.layout.simple_spinner_item, bars);
            spinner.setSelected(true);
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    Timber.i("IdItem%s", String.valueOf(i));
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                    Timber.i("onNothingSelected");
                }
            });
        });

        view.findViewById(R.id.buttonAdd).setOnClickListener(view1 -> {

            String name = editTextNewName.getText().toString();
            String address = editTextNewAddress.getText().toString();
            String description = editTextDescription.getText().toString();

            Bundle bundle = getArguments();
            Event event = bundle.getParcelable("event");

            User user = event.getEventCreator();

            // Bar(String barName, String barDescription, String address, int averageСheck, String imageUrl)
            // Event(String eventName, Bar bar, String address, int countPeople, String description, User eventCreator)

            Event newEvent = new Event(name, (Bar) spinner.getSelectedItem(), address, 0, description, user);

            bundle.putParcelable("newevent", newEvent);
            Navigation.findNavController(view1).
                    navigate(R.id.action_addFragment_to_listVulkanovFragment, bundle);
        });

        return view;
    }

}
