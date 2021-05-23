package com.example.mycms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class DonorEventsAdapter extends FirebaseRecyclerAdapter<Events, DonorEventsAdapter.DonorViewHolder> {

    public DonorEventsAdapter(@NonNull FirebaseRecyclerOptions<Events> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull DonorEventsAdapter.DonorViewHolder holder, int position, @NonNull Events model) {
        holder.eventName.setText(model.getEventname());
        holder.eventDesc.setText(model.getEventdescription());
        holder.ngoName.setText(model.getNgoName());
        holder.eventAddress.setText(model.getAddress());
        holder.eventDate.setText(model.getDate());
        holder.eventTime.setText(model.getTime());

    }

    @NonNull
    @Override
    public DonorEventsAdapter.DonorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event, parent, false);
        return new DonorEventsAdapter.DonorViewHolder(view);
    }

    public class DonorViewHolder extends RecyclerView.ViewHolder{

        View v1;
        TextView eventName, eventDesc,ngoName, eventDate,eventTime, eventAddress;
        public DonorViewHolder(@NonNull View itemView) {
            super(itemView);


            eventName = itemView.findViewById(R.id.eventname);
            eventAddress = itemView.findViewById(R.id.eventaddress);
            ngoName = itemView.findViewById(R.id.eventNgoname);
            eventDate = itemView.findViewById(R.id.eventdate);
            eventTime = itemView.findViewById(R.id.eventtime);
            eventDesc = itemView.findViewById(R.id.eventdesc);
            v1= itemView;

        }
    }
}
