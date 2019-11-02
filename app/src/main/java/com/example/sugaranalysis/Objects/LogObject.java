package com.example.sugaranalysis.Objects;

public class LogObject {

    //private String itemNDB; // primary key on https://ndb.nal.usda.gov/ndb/
    private String itemName;
    private String itemMeasure;
    //private String itemUnit;
    private String itemValue;

    public LogObject() {
        //itemNDB = "";
        itemName = "";
        itemMeasure = "";
        //itemUnit = "";
        itemValue = "";
    }

    public LogObject(String itemName,String itemMeasure, String itemValue) {
        //this.itemNDB = itemNDB;
        this.itemName = itemName;
        this.itemMeasure = itemMeasure;
        //this.itemUnit = itemUnit;
        this.itemValue = itemValue;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    //public String getItemNDB() {
    //return itemNDB;
    //}

    // public void setItemNDB(String itemNDB) {
    //this.itemNDB = itemNDB;
    //}

    public String getItemMeasure() {
        return itemMeasure;
    }

    public void setItemMeasure(String itemMeasure) {
        this.itemMeasure = itemMeasure;
    }

//    public String getItemUnit() {
//        return itemUnit;
//    }
//
//    public void setItemUnit(String itemUnit) {
//        this.itemUnit = itemUnit;
//    }

    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemMeasure = itemValue;
    }

    //You can modify this if you want
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
    }

}