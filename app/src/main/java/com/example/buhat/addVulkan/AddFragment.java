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
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.buhat.BD.Bar;
import com.example.buhat.BD.Event;
import com.example.buhat.BD.User;
import com.example.buhat.R;
import com.example.buhat.network.App;
import com.example.buhat.network.VulkanApiService;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;


public class AddFragment extends Fragment {

    private VulkanApiService apiService = App.getApi();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add, container, false);

        EditText editTextNewName = view.findViewById(R.id.editTextNewName);
        EditText editTextNewAddress = view.findViewById(R.id.editTextNewAddress);
        EditText editTextDescription = view.findViewById(R.id.editTextDescription);
        EditText editTextAverageCheck = view.findViewById(R.id.editTextAverageCheck);

        final Bar[] bar = {null};

        apiService.getListBar().enqueue(new Callback<List<Bar>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(@NotNull Call<List<Bar>> call, @NotNull Response<List<Bar>> response) {
                if (response.isSuccessful() && response.body() != null) {

                    List<String> barList = new ArrayList<>();
                    response.body().forEach(bar -> barList.add(bar.getBarName()));
                    Spinner spinner = view.findViewById(R.id.spinner);

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                            android.R.layout.simple_spinner_item, barList);
                    spinner.setSelected(true);
                    spinner.setAdapter(adapter);
                    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            Timber.i("IdItem" + String.valueOf(i));
                            bar[0] = response.body().get(i);
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<List<Bar>> call, Throwable t) {

            }
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

            Event newEvent = new Event(name, bar[0], address, 0, description, user);
            Timber.i(bar[0].getBarName());

            apiService.postData(newEvent).enqueue(new Callback<Event>() {
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

            bundle.putParcelable("newevent", newEvent);
            Navigation.findNavController(view1).
                    navigate(R.id.action_addFragment_to_listVulkanovFragment, bundle);
        });

        return view;
    }

}
