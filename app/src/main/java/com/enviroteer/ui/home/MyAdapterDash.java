package com.enviroteer.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.enviroteer.R;
import com.enviroteer.ui.Detail;

import java.util.ArrayList;

public class MyAdapterDash extends RecyclerView.Adapter<MyViewHolderDash> {

    Context context;

    public MyAdapterDash(Context context, ArrayList<Detail> details) {
        this.context = context;
        this.details = details;
    }

    ArrayList<Detail> details;
    @NonNull
    @Override
    public MyViewHolderDash onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolderDash(LayoutInflater.from(context).inflate(R.layout.detail_view_dash,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderDash holder, int position) {
        holder.detail = details.get(position);
        holder.eventName.setText(details.get(position).getName());
        holder.location.setText(details.get(position).getLocation());
        holder.endTime.setText(details.get(position).getEndTime());
        holder.startTime.setText(details.get(position).getStartTime());
        holder.date.setText(details.get(position).getDate());
        holder.description.setText(details.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return details.size();
    }
}
