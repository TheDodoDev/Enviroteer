package com.enviroteer.ui;

import java.util.ArrayList;

public class DetailStorage {
    static ArrayList<Detail> details;
    public DetailStorage() {
        this.details = new ArrayList<>();
        details.add(new Detail("Spotless Pashupati Initiative", "Pashpatinath, a national heritage of Nepal, is not so clean as it should have been. We are organizing a program to make it clean and green. Come join us!","Pashupatinath, Nepal", "14/08/2023","11:00", "18:00"));
        details.add(new Detail("Let's Imagine Clean Bagmati!", "Have you ever imagined clean Bagmati? Let's come together to make it clean.","Kathmandu, Nepal", "17/08/2023","10:00", "16:00"));
    }

    public static ArrayList<Detail> getDetails()
    {
        return details;
    }
}
