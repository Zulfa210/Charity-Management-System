package com.example.mycms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;


public class AppointViewAdapter extends FirebaseRecyclerAdapter<Appointment,AppointViewAdapter.ViewHolderapp> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public AppointViewAdapter(@NonNull FirebaseRecyclerOptions<Appointment> options) {
        super(options);

    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolderapp holder, int position, @NonNull Appointment model) {

        holder.donorName.setText(model.getName());
        holder.date.setText(model.getDate());
        holder.phone.setText(model.getPhoneNo());
        holder.time.setText(model.getTime());


    }

    @NonNull
    @Override
    public ViewHolderapp onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ngo_feed, parent, false);
        return new ViewHolderapp(view);

    }

    public class ViewHolderapp extends RecyclerView.ViewHolder {

        TextView donorName, date, time, phone;


        public ViewHolderapp(@NonNull View itemView) {
            super(itemView);
            View vv;
           donorName = itemView.findViewById(R.id.Dname);
           date= itemView.findViewById(R.id.appointDate);
           time = itemView.findViewById(R.id.appointTime);
           phone = itemView.findViewById(R.id.appointPhone);
           vv = itemView;





        }
    }
}
