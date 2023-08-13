package com.enviroteer.ui;

import java.util.ArrayList;

public class DetailStorage {
    static ArrayList<Detail> details;
    public DetailStorage() {
        this.details = new ArrayList<>();
        details.add(new Detail("Event A", "Hello","Nepal", "10/10/2010","11:00", "12:00"));
    }

    public static ArrayList<Detail> getDetails()
    {
        return details;
    }
}
