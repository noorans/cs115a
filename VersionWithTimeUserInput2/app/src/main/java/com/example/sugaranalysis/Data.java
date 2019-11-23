package com.example.sugaranalysis;

// Object class
public class Data {
    String days;
    int levels;

    public Data(String days, int levels) {
        this.days = days;
        this.levels = levels;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getDays() {
        return days;
    }

    public int getLevels() {
        return levels;
    }

    public void setLevels(int levels) {
        this.levels = levels;
    }
}
