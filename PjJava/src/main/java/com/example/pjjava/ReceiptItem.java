package com.example.pjjava;

public class ReceiptItem {
    private String dishName;
    private int quantity;
    private double price;

    public ReceiptItem() {
    }

    public ReceiptItem(String dishName, int quantity, double price) {
        this.dishName = dishName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmount(){
        return quantity * price;
    }
    @Override
    public String toString() {
        return "ReceiptItem{" +
                "dishName='" + dishName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
