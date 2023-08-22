package com.example.utils;

public enum PassType {
    MONTHLY(21);

    private int days;

    public int getDays() {
        return days;
    }



    PassType(int i) {
        this.days = i;
    }
}
