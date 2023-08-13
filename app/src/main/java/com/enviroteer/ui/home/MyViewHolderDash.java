package com.enviroteer.ui.home;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.enviroteer.R;
import com.enviroteer.ui.Detail;

public class MyViewHolderDash extends RecyclerView.ViewHolder {
    Detail detail;
    TextView eventName, description, startTime, endTime, location, date;
    Button more;
    public MyViewHolderDash(@NonNull View itemView) {
        super(itemView);
        eventName = itemView.findViewById(R.id.event_name_dash);
        description = itemView.findViewById(R.id.event_description_dash);
        location = itemView.findViewById(R.id.event_location_dash);
        startTime = itemView.findViewById(R.id.startTimeDash);
        endTime = itemView.findViewById(R.id.endTimeDash);
        date = itemView.findViewById(R.id.dateDash);
        more = itemView.findViewById(R.id.more_detail_button_dash);
    }
}
