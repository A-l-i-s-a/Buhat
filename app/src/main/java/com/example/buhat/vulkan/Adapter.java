package com.example.buhat.vulkan;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buhat.BD.Event;
import com.example.buhat.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<Event> events;
    private final ViewHolder.Listener onClickListener;

    public Adapter(List<Event> events, ViewHolder.Listener onClickListener) {
        this.events = events;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vulkan, parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListener.onMovieClick((Event) view.getTag());
            }
        });
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Event event = events.get(position);
        holder.bind(event);
        holder.itemView.setTag(event);
    }

    @Override
    public int getItemCount() {
        return events.size();
    }


    void setEvents(List<Event> events) {
        this.events = events;
        notifyDataSetChanged();
    }

    final static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView textViewName;
        private final TextView textViewMesto;
        private final TextView textViewCountLudey;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewMesto = itemView.findViewById(R.id.textViewMesto);
            textViewCountLudey = itemView.findViewById(R.id.textViewCountLudey);
        }

        @SuppressLint("SetTextI18n")
        private void bind(@NonNull Event event) {
            textViewName.setText(event.getEventName());
            textViewCountLudey.setText(Integer.toString(event.getCountPeople()));
            textViewMesto.setText(event.getAddress());

        }

        interface Listener {
            void onMovieClick(Event chat);
        }

    }
}