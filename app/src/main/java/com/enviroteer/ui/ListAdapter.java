package com.enviroteer.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.enviroteer.R;
import com.enviroteer.databinding.ListElementBinding;

import java.util.Date;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{
    private List<VolunteerProgram> mData;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdapter(List<VolunteerProgram> itemList, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }
    @Override
    public int getItemCount(){return mData.size();}

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.list_element, null);
        return new ListAdapter.ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position){
        holder.bindData(mData.get(position));
    }
    public void setItems(List<VolunteerProgram> items){mData = items;}

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iconImage;
        TextView name, location, date;
        ViewHolder(View itemView){
            super(itemView);
            iconImage = itemView.findViewById(R.id.iconImageView);
            name = itemView.findViewById(R.id.programNameTextView);
            location = itemView.findViewById(R.id.programLocationTextView);
            date = itemView.findViewById(R.id.programDateTextView);
        }
        void bindData(final VolunteerProgram item){
            //iconImage.setImageIcon();
            name.setText(item.getName());
            location.setText(item.getLocation());
            date.setText(item.getDate());

        }
    }


}
