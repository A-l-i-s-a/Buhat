package com.example.buhat.vulkan;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appforran.database.Running;
import com.example.buhat.R;

import java.text.SimpleDateFormat;
import java.util.List;

import timber.log.Timber;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private  List<Running> runnings;
    private final ViewHolder.Listener onClickListener;

    public Adapter(List<Running> runnings, ViewHolder.Listener onClickListener) {
        this.runnings = runnings;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vulkan, parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListener.onMovieClick((Running) view.getTag());
            }
        });
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Running running = runnings.get(position);
        holder.bind(running);
        holder.itemView.setTag(running);
    }

    @Override
    public int getItemCount() {
        return runnings.size();
    }


    void setRunnings(List<Running> runnings) {
        this.runnings = runnings;
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
        private void bind(@NonNull Running running) {
            Timber.d("running.id = %s", running.id);
            textViewName.setText(Integer.toString(running.id));
            @SuppressLint("SimpleDateFormat") SimpleDateFormat formatForDateNow = new SimpleDateFormat("hh:mm:ss");
            Long t = running.time;
            if (t != null) {
                textViewCountLudey.setText(formatForDateNow.format(t));
            }
            textViewMesto.setText(running.date.toString());
        }

        interface Listener {
            void onMovieClick(Running chat);
        }

    }
}