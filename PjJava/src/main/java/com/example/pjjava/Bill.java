package com.example.pjjava;

public class Bill {
    private String billID;
    private String dishID;
    private String dishName;
    private String type;
    private Double price;
    private Integer quantity;

    public Bill() {
    }

    public Bill(String billID, String dishName, String type, Double price, Integer quantity) {
        this.billID = billID;
        this.dishName = dishName;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }

    public Bill(String billID, String dishID, String dishName, String type, Double price, Integer quantity) {
        this.billID = billID;
        this.dishID = dishID;
        this.dishName = dishName;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }

    public String getBillID() {
        return billID;
    }

    public void setBillID(String billDishID) {
        this.billID = billDishID;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billID='" + billID + '\'' +
                ", dishID='" + dishID + '\'' +
                ", dishName='" + dishName + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
