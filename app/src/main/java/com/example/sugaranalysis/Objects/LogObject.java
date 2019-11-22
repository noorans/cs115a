package com.example.sugaranalysis.Objects;

public class LogObject {

    //private String itemNDB;
    private String logAvg_bmi;
    private String logMoment;
    private String logDate;
    private String logTime;
    private String logHeight;
    private String logWeight;

    //Constructor
    public LogObject() {
        logAvg_bmi = "";
        logMoment = "";
        logDate = "";
        logTime = "";
        logHeight = "";
        logWeight = "";

    }

    public LogObject(String logAvg_bmi, String logMoment, String logDate, String logTime, String logHeight, String logWeight) {
        this.logAvg_bmi = logAvg_bmi;
        this.logMoment = logMoment;
        this.logDate = logDate;
        this.logTime = logTime;
        this.logHeight = logHeight;
        this.logWeight = logWeight;
    }

    public String getLogAvg_bmi() { return logAvg_bmi; }

    public void setLogAvg_bmi(String logAvg_bmi) { this.logAvg_bmi = logAvg_bmi; }

    public String getLogMoment() {
        return logMoment;
    }

    public void setLogMoment(String logMoment) {
        this.logMoment = logMoment;
    }

    public String getLogDate() {
        return logDate;
    }

    public void setLogDate(String logDate) {
        this.logDate = logDate;
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