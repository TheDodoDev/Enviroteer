package com.enviroteer.ui;

import android.location.Location;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Detail {
    public String name, description, location, date;
    public String startTime, endTime;
    public ArrayList<String> participants;

    public Detail(String name, String description, String location, String date, String startTime, String endTime) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        participants = new ArrayList<>();
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public void setStartTime(String startTime)
    {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime)
    {
        this.endTime = endTime;
    }
    public void addParticipants(String username)
    {
        participants.add(username);
    }
}

