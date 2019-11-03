package com.example.buhat.loginAndRegestration;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.buhat.R;


public class RegistrationFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registration, container, false);

        view.findViewById(R.id.buttonRegistrationEntity)
                .setOnClickListener(view1 ->
                        Navigation.findNavController(view1)
                                .navigate(R.id.action_registrationFragment_to_listVulkanovFragment));
        return view;
    }

}
