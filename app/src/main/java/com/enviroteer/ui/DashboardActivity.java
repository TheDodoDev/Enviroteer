package com.enviroteer.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.enviroteer.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {
    List<VolunteerProgram> upcomingPrograms;
    List<VolunteerProgram> hostedPrograms;
    private Button upcomingButton,hostedButton;
    private View viewUpcomingLine, viewHostedLine;
    private View upcomingRecyclerView;
    private View hostedRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        upcomingButton = findViewById(R.id.btn_upcoming);
        hostedButton = findViewById(R.id.btn_hosted);
        viewHostedLine = findViewById(R.id.hostedLineDashboard);
        viewUpcomingLine = findViewById(R.id.upcomingLineDashboard);

        upcomingRecyclerView = findViewById(R.id.upcoming_recycler_view);
        hostedRecyclerView = findViewById(R.id.hosted_recycler_view);

        upcomingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (upcomingRecyclerView.getVisibility() != View.VISIBLE) {
                    viewHostedLine.setVisibility(View.INVISIBLE);
                    hostedRecyclerView.setVisibility(View.GONE);
                    viewUpcomingLine.setVisibility(View.VISIBLE);
                    upcomingRecyclerView.setVisibility(View.VISIBLE);
                }
            }
        });
        hostedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hostedRecyclerView.getVisibility() != View.VISIBLE) {
                    viewUpcomingLine.setVisibility(View.INVISIBLE);
                    upcomingRecyclerView.setVisibility(View.GONE);
                    viewHostedLine.setVisibility(View.VISIBLE);
                    hostedRecyclerView.setVisibility(View.VISIBLE);
                }
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, CreateVolunteerProgram.class);
                startActivity(intent);
            }
        });


        initRecyclerView();
    }
    public void initRecyclerView(){
        upcomingPrograms = new ArrayList<>();
        upcomingPrograms.add(new VolunteerProgram("Volunteer Example","12/08/23","Los Angeles"));

        hostedPrograms = new ArrayList<>();
        hostedPrograms.add(new VolunteerProgram("Volunteer Example 2","15/08/2023","California"));

        ListAdapter listAdapterSignedUp = new ListAdapter(upcomingPrograms,this);
        RecyclerView recyclerViewSignedUp = findViewById(R.id.upcoming_recycler_view);
        recyclerViewSignedUp.setHasFixedSize(true);
        recyclerViewSignedUp.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewSignedUp.setAdapter(listAdapterSignedUp);


        ListAdapter listAdapterHosted = new ListAdapter(hostedPrograms, this);
        RecyclerView recyclerViewHosted = findViewById(R.id.hosted_recycler_view);
        recyclerViewHosted.setHasFixedSize(true);
        recyclerViewHosted.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewHosted.setAdapter(listAdapterHosted);

    }
}