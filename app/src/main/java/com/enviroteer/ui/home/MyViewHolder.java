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

public class MyViewHolder extends RecyclerView.ViewHolder {
    Detail detail;
    TextView eventName, description, startTime, endTime, location, date;
    Button signUp, more;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        eventName = itemView.findViewById(R.id.event_name);
        description = itemView.findViewById(R.id.event_description);
        location = itemView.findViewById(R.id.event_location);
        startTime = itemView.findViewById(R.id.startTime);
        endTime = itemView.findViewById(R.id.endTime);
        date = itemView.findViewById(R.id.date);
        signUp = itemView.findViewById(R.id.sign_up_button);
        more = itemView.findViewById(R.id.more_detail_button);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!detail.participants.contains("ThisUser"))
                {
                    detail.addParticipants("ThisUser");
                    Toast t = Toast.makeText(view.getContext(), "Registered Successfully", Toast.LENGTH_SHORT);
                    t.show();
                    Log.d("Clicked", "Clicked");
                }
                else {
                    Toast t = Toast.makeText(view.getContext(), "Already Registered", Toast.LENGTH_SHORT);
                    t.show();
                }

            }
        });
    }
}
