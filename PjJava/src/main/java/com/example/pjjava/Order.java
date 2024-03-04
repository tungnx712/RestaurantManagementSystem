package com.example.pjjava;

public class Order {
    private String dish_name;
    private int quantity;
    private double amount;

    public Order() {
    }

    public Order( String dish_name, int quantity, double amount) {

        this.dish_name = dish_name;
        this.quantity = quantity;
        this.amount = amount;
    }





    public String getDish_name() {
        return dish_name;
    }

    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                ", dish_name='" + dish_name + '\'' +
                ", quantity=" + quantity +
                ", amount=" + amount +
                '}';
    }
}
