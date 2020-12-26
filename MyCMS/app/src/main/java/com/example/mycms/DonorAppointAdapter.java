package com.example.mycms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;



public class DonorAppointAdapter extends FirebaseRecyclerAdapter<Appointment,DonorAppointAdapter.ViewHolderDonor> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public DonorAppointAdapter(@NonNull FirebaseRecyclerOptions<Appointment> options) {
        super(options);

    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolderDonor holder, int position, @NonNull Appointment model) {

        holder.donorName.setText(model.getNgo_Name());
        holder.date.setText(model.getDate());
        //holder.phone.setText(model.getPhoneNo());
        holder.time.setText(model.getTime());


    }

    @NonNull
    @Override
    public ViewHolderDonor onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.donor_appointments, parent, false);
        return new ViewHolderDonor(view);

    }

    public class ViewHolderDonor extends RecyclerView.ViewHolder {

        TextView donorName, date, time, phone;


        public ViewHolderDonor(@NonNull View itemView) {
            super(itemView);
            View vv;
            donorName = (TextView) itemView.findViewById(R.id.Nname);
            date= (TextView) itemView.findViewById(R.id.NDate);
            time =(TextView) itemView.findViewById(R.id.NTime);
          //  phone = itemView.findViewById(R.id.appointPhone);
            vv = itemView;





        }
    }
}