package com.example.buhat.loginAndRegestration;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.buhat.BD.User;
import com.example.buhat.network.Repository;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<User> mutableLiveData;
    private Repository repository;

    public void init(String login) {
        if (mutableLiveData != null) {
            return;
        }
        repository = Repository.getInstance();
        mutableLiveData = repository.getUser(login);
    }

    public LiveData<User> getMutableLiveData() {
        return mutableLiveData;
    }

    public Repository getRepository() {
        return repository;
    }
}
