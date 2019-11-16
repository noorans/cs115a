package com.example.sugaranalysis.Objects;

public class LogObject {

    //private String itemNDB;
    private String logAvg_bmi;
    private String logTime;
    private String logHeight;
    private String logWeight;

    //Constructor
    public LogObject() {
        logAvg_bmi = "";
        logTime = "";
        logHeight = "";
        logWeight = "";

    }

    public LogObject(String logAvg_bmi, String logTime, String logHeight, String logWeight) {
        //this.itemNDB = itemNDB;
        this.logAvg_bmi = logAvg_bmi;
        this.logTime = logTime;
        this.logHeight = logHeight;
        this.logWeight = logWeight;
    }

    public String getItemName() {
        return logAvg_bmi;
    }

    public void setLogAvg_bmi(String logAvg_bmi) {
        this.logAvg_bmi = logAvg_bmi;
    }

    public String getLogTime() {
        return logTime;
    }

    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }

    public String getLogHeight() {
        return logHeight;
    }

    public void setLogHeight(String logHeight) {
        this.logHeight = logHeight;
    }

    public String getLogWeight() {
        return logWeight;
    }

    public void setLogWeight(String logWeight) {
        this.logWeight = logWeight;
    }

    //You can modify this if you want
    /*
    @Override
    public String toString() {
        return "FoodItem{" +
                "itemName='" + itemName + '\'' +
                ", itemMeasure='" + itemMeasure + '\'' +
                '}';
    }
    public String details(){
        return  "fl oz: " + this.getItemMeasure() + "\n" +
                this.getItemValue() + " "+
                "mg\n";
    }*/

}