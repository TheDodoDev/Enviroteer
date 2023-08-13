package com.enviroteer.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.enviroteer.R;
import com.enviroteer.ui.home.MyAdapter;
import com.enviroteer.ui.home.MyAdapterDash;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {
    ArrayList<Detail> upcomingPrograms;
    ArrayList<Detail> hostedPrograms;
    private Button upcomingButton,hostedButton;
    private View viewUpcomingLine, viewHostedLine;
    private View upcomingRecyclerView;
    private View hostedRecyclerView;
    private Bundle extras;

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
        extras = getIntent().getExtras();

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
                finish();
            }
        });


        initRecyclerView();
    }
    public void initRecyclerView(){
        upcomingPrograms = new ArrayList<Detail>();
        upcomingPrograms.add(new Detail("Spotless Pashupati Initiative", "Pashpatinath, a national heritage of Nepal, is not so clean as it should have been. We are organizing a program to make it clean and green. Come join us!","Pashupatinath, Nepal", "08/14/2023","11:00", "18:00"));
        if(extras != null) {
            String name = extras.getString("name");
            String location = extras.getString("location");
            String date = extras.getString("date");
            String startTime = extras.getString("startTime");
            String endTime = extras.getString("endTime");
            String description = extras.getString("description");
            upcomingPrograms.add(new Detail(name, description, location, date, startTime, endTime));
        }
        hostedPrograms = new ArrayList<>();
        hostedPrograms.add(new Detail("Chovar Will Be Green Again!", "Chovar has lost its greenary in the last few years. Shall we make it green again?","Chovar, Nepal", "07/29/2023","10:00", "18:00"));

        MyAdapterDash listAdapterSignedUp = new MyAdapterDash(getApplicationContext(), upcomingPrograms);
        RecyclerView recyclerViewSignedUp = findViewById(R.id.upcoming_recycler_view);
        recyclerViewSignedUp.setHasFixedSize(true);
        recyclerViewSignedUp.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewSignedUp.setAdapter(listAdapterSignedUp);


        MyAdapterDash listAdapterHosted = new MyAdapterDash(getApplicationContext(), hostedPrograms);
        RecyclerView recyclerViewHosted = findViewById(R.id.hosted_recycler_view);
        recyclerViewHosted.setHasFixedSize(true);
        recyclerViewHosted.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewHosted.setAdapter(listAdapterHosted);

    }
}