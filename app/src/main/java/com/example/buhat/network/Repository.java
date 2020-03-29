package com.example.buhat.network;

import androidx.lifecycle.MutableLiveData;

import com.example.buhat.BD.Bar;
import com.example.buhat.BD.Event;
import com.example.buhat.BD.User;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class Repository {
    private static Repository repository;
    private ApiService apiService;

    public Repository() {
        apiService = App.getApi();
    }

    public static Repository getInstance() {
        if (repository == null) {
            repository = new Repository();
        }
        return repository;
    }

    public MutableLiveData<List<Event>> getListEvents() {
        MutableLiveData<List<Event>> newEvents = new MutableLiveData<>();
        apiService.getListEvents().enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(@NotNull Call<List<Event>> call, @NotNull Response<List<Event>> response) {
                if (response.isSuccessful()) {
                    newEvents.setValue(response.body());
                    Timber.i(" onResponse");
                }
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {
                newEvents.setValue(null);
                Timber.i(t);
            }
        });
        return newEvents;
    }

    public MutableLiveData<User> getUser(String login) {
        MutableLiveData<User> newUser = new MutableLiveData<>();
        apiService.getUser(login).enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NotNull Call<User> call, @NotNull Response<User> response) {
                if (response.isSuccessful()) {
                    newUser.setValue(response.body());
                    Timber.i(" onResponse = %s", response.body());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                newUser.setValue(null);
                Timber.i(t);
            }
        });
        return newUser;
    }

    public MutableLiveData<List<Bar>> getListBar() {
        MutableLiveData<List<Bar>> listBar = new MutableLiveData<>();
        apiService.getListBar().enqueue(new Callback<List<Bar>>() {
            @Override
            public void onResponse(@NotNull Call<List<Bar>> call, @NotNull Response<List<Bar>> response) {
                if (response.isSuccessful()) {
                    listBar.setValue(response.body());
                    Timber.i(" onResponse = %s", response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Bar>> call, Throwable t) {
                listBar.setValue(null);
                Timber.i(t);
            }
        });

        return listBar;
    }

    public void postEvent(Event event) {
        apiService.postData(event).enqueue(new Callback<Event>() {
            @Override
            public void onResponse(Call<Event> call, Response<Event> response) {
                if (response.isSuccessful()) {
                    Timber.i("response %s", response.body().getEventName());
                } else {
                    Timber.i("response code %s", response.code());
                }
            }

            @Override
            public void onFailure(Call<Event> call, Throwable t) {
                Timber.i(t);
            }
        });

    }
}
