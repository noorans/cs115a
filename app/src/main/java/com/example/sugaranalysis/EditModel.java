package com.example.sugaranalysis;

public class EditModel {
    //use objects of this model to retain edittext value when scrolling listview

    private String bloodSugarValue;

    //using getter and setter methods
    public String getEditTextValue() {
        return bloodSugarValue;
    }

    public void setEditTextValue(String editTextValue) {
        this.bloodSugarValue = editTextValue;
    }
}
