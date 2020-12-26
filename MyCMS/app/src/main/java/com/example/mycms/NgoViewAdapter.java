package com.example.mycms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import static androidx.core.content.ContextCompat.startActivity;

public class NgoViewAdapter extends FirebaseRecyclerAdapter<NgoUser,NgoViewAdapter.Viewholder_Ngo> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public NgoViewAdapter(@NonNull FirebaseRecyclerOptions<NgoUser> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull NgoViewAdapter.Viewholder_Ngo holder, int position, @NonNull NgoUser model) {
        holder.ngo_name.setText(model.getName());
        holder.ngo_address.setText(model.getAddress());
        holder.ngo_phone.setText(model.getPhone());
            holder.profile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppCompatActivity activity=(AppCompatActivity) v.getContext();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.dash, new NgoProfile(model.getName(),model.getPerson(),model.getPhone(),model.getEmail(), model.getAddress(),model.getReg(),model.getUpi(),model.getStatus())).addToBackStack(null).commit();

                }
            });

    }


    @NonNull
    @Override
    public Viewholder_Ngo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ngo_item, parent, false);
        return new Viewholder_Ngo(view);
    }

    public class Viewholder_Ngo extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView ngo_name, ngo_address, ngo_phone, profile;
        View v;
        public Viewholder_Ngo(@NonNull View itemView) {
            super(itemView);

            imageView= itemView.findViewById(R.id.logo);
            ngo_name = itemView.findViewById(R.id.Ngo_name);
            ngo_phone = itemView.findViewById(R.id.Ngo_phone);
            ngo_address = itemView.findViewById(R.id.Ngo_address);
            profile = itemView.findViewById(R.id.Read_more);
            v= itemView;
        }

//    public void setItem(FragmentActivity activity, String name;
//            String person;
//            String email;
//            String phone;
//            String address;
//            String reg;
//            String upi;
//            String status){
//        imageView= itemView.findViewById(R.id.logo);
//        ngo_name = itemView.findViewById(R.id.Ngo_name);
//        ngo_phone = itemView.findViewById(R.id.Ngo_phone);
//        ngo_address = itemView.findViewById(R.id.Ngo_address);
//
//        ngo_name.setText(name);
//        ngo_phone.setText(phone);
//
//    }


    }
}
