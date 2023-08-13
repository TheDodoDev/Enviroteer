package com.enviroteer.ui.home;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.enviroteer.R;
import com.enviroteer.ui.Detail;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;

    public MyAdapter(Context context, ArrayList<Detail> details) {
        this.context = context;
        this.details = details;
    }

    ArrayList<Detail> details;
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.detail_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.detail = details.get(position);
        holder.eventName.setText(details.get(position).name);
        holder.location.setText(details.get(position).location);
        holder.more.setText(details.get(position).date);
    }

    @Override
    public int getItemCount() {
        return details.size();
    }
}
