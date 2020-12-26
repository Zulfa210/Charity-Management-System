package com.example.mycms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class EventViewAdapter extends FirebaseRecyclerAdapter<Events,EventViewAdapter.Viewholder_Event> {


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public EventViewAdapter(@NonNull FirebaseRecyclerOptions<Events> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull EventViewAdapter.Viewholder_Event holder, int position, @NonNull Events model) {
        holder.eventName.setText(model.getEventname());
        holder.eventDesc.setText(model.getEventdescription());
        holder.ngoName.setText(model.getNgoName());
        holder.eventAddress.setText(model.getAddress());
        holder.eventDate.setText(model.getDate());
        holder.eventTime.setText(model.getTime());
    }

    @NonNull
    @Override
    public Viewholder_Event onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ngo_event, parent, false);
        return new Viewholder_Event(view);
    }

    public class Viewholder_Event extends RecyclerView.ViewHolder{

        View v1;
        TextView eventName, eventDesc,ngoName, eventDate,eventTime, eventAddress;
        public Viewholder_Event(@NonNull View itemView) {
            super(itemView);


            eventName = itemView.findViewById(R.id.eventName);
            eventAddress = itemView.findViewById(R.id.eventAddress);
            ngoName = itemView.findViewById(R.id.eventNgoName);
            eventDate = itemView.findViewById(R.id.eventDate);
            eventTime = itemView.findViewById(R.id.eventTime);
            eventDesc = itemView.findViewById(R.id.eventDesc);
            v1= itemView;

        }
    }
}
