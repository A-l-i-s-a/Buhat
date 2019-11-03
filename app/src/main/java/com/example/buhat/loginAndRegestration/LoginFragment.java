package com.example.buhat.loginAndRegestration;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.buhat.BD.User;
import com.example.buhat.R;

import timber.log.Timber;


public class LoginFragment extends Fragment {

    User user;
    LoginViewModel loginViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_login, container, false);

        EditText editTextLogin = view.findViewById(R.id.editTextLogin);
        EditText editTextPassword = view.findViewById(R.id.editTextLoginPassword);

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        String login = editTextLogin.getText().toString();

        loginViewModel.init(editTextLogin.getText().toString());


        view.findViewById(R.id.buttonReg)
                .setOnClickListener(view1 ->
                        Navigation.findNavController(view1)
                                .navigate(R.id.action_loginFragment_to_registrationFragment));



        view.findViewById(R.id.buttonLogin)
                .setOnClickListener(view12 -> {

//                    loginViewModel.getMutableLiveData().observe(this, list -> {
//                        user = list;
//                        Timber.i(list.toString());
//
//                        Timber.i(list.toString());
//                        if (list.getPassword().equals(editTextPassword.getText().toString()))
//                            Navigation.findNavController(view12)
//                                    .navigate(R.id.action_loginFragment_to_listVulkanovFragment);
//                    });

                    Navigation.findNavController(view12)
                            .navigate(R.id.action_loginFragment_to_listVulkanovFragment);

                });
        return view;
    }

}
