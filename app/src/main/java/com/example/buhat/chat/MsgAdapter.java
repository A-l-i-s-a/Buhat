package com.example.buhat.chat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buhat.R;

import java.text.SimpleDateFormat;
import java.util.List;

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.MsgViewHolder>  {

    private final List<Msg> msgs;

    public MsgAdapter(List<Msg> msgs) {
        this.msgs = msgs;
    }

    @NonNull
    @Override
    public MsgViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg, parent, false);
        return new MsgViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MsgViewHolder holder, int position) {
        Msg msg = msgs.get(position);
        holder.bind(msg);
    }

    @Override
    public int getItemCount() {
        return msgs.size();
    }

    final static class MsgViewHolder extends RecyclerView.ViewHolder {

        private final CardView cardView;
        private final TextView textViewUsername;
        private final TextView textViewTextMsg;
        private final TextView textViewTimeMsg;


        public MsgViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cv);
            textViewUsername = itemView.findViewById(R.id.textViewUsername);
            textViewTextMsg = itemView.findViewById(R.id.textViewMsgText);
            textViewTimeMsg = itemView.findViewById(R.id.textViewMsgTime);
        }

        private void bind(@NonNull Msg msg) {
            textViewUsername.setText(msg.getName());
            textViewTextMsg.setText(msg.getMsg());
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("hh:mm");
            textViewTimeMsg.setText(formatForDateNow.format(msg.getDate().getTime()));

        }

    }
}
