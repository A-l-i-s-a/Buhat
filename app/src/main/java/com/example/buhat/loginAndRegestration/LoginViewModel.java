package com.example.buhat.loginAndRegestration;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.buhat.BD.User;
import com.example.buhat.network.DataRepository;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<User> mutableLiveData;
    private DataRepository dataRepository;

    public void init(String login) {
        if (mutableLiveData != null) {
            return;
        }
        dataRepository = DataRepository.getInstance();
        mutableLiveData = dataRepository.getUser(login);
    }

    public LiveData<User> getMutableLiveData() {
        return mutableLiveData;
    }

    public DataRepository getDataRepository() {
        return dataRepository;
    }
}
