package com.example.buhat.addVulkan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.buhat.BD.Bar;
import com.example.buhat.BD.Event;
import com.example.buhat.BD.User;
import com.example.buhat.R;


public class AddFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add, container, false);

        EditText editTextNewName = view.findViewById(R.id.editTextNewName);
        EditText editTextNewAddress = view.findViewById(R.id.editTextNewAddress);
        EditText editTextDescription = view.findViewById(R.id.editTextDescription);
        EditText editTextUrl = view.findViewById(R.id.editTextUrl);
        EditText editTextAverageCheck = view.findViewById(R.id.editTextAverageCheck);



        view.findViewById(R.id.buttonAdd).setOnClickListener(view1 -> {

            String name = editTextNewName.getText().toString();
            String address = editTextNewAddress.getText().toString();
            String description = editTextDescription.getText().toString();
            String url = editTextUrl.getText().toString();

            int averageCheck = Integer.parseInt(editTextAverageCheck.getText().toString());

            Bundle bundle = getArguments();
            Event event = bundle.getParcelable("event");

            User user = event.getEventCreator();

            // Bar(String barName, String barDescription, String address, int averageСheck, String imageUrl)
            // Event(String eventName, Bar bar, String address, int countPeople, String description, User eventCreator)

            Bar bar = new Bar(name, description, address, averageCheck, url);
            Event newEvent = new Event(name, bar, address, 0, description, user);

            bundle.putParcelable("newevent", newEvent);
                Navigation.findNavController(view1).
                        navigate(R.id.action_addFragment_to_listVulkanovFragment, bundle);});

        return view;
    }

}
