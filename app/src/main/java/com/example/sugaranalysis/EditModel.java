package com.example.sugaranalysis;

public class EditModel {
    //use objects of this model to retain edittext value when scrolling listview

    private String bloodSugarValue;
    private String title;

    //using getter and setter methods
    public String getEditTextValue() {
        return  bloodSugarValue;
    }

    public void setEditTextValue(String bloodSugarValue) {
        this.bloodSugarValue = bloodSugarValue;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
