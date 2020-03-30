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

public class DataRepository implements Repository {
    private static DataRepository dataRepository;
    private ApiService apiService;

    public DataRepository() {
        apiService = App.getApi();
    }

    public static DataRepository getInstance() {
        if (dataRepository == null) {
            dataRepository = new DataRepository();
        }
        return dataRepository;
    }

    @Override
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

    @Override
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

    @Override
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

    @Override
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
