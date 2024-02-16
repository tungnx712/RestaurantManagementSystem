package com.example.pjjava;

public class Categories {
    private String dishID;
    private String dishName;
    private String price;
    private String availability;
    private String type;

    public Categories() {
    }

    public Categories(String dishID, String dishName, String price, String availability, String type) {
        this.dishID = dishID;
        this.dishName = dishName;
        this.price = price;
        this.availability = availability;
        this.type = type;
    }

    public String getDishID() {
        return dishID;
    }

    public void setDishID(String dishID) {
        this.dishID = dishID;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "dishID='" + dishID + '\'' +
                ", dishName='" + dishName + '\'' +
                ", price='" + price + '\'' +
                ", availability='" + availability + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
