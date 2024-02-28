package com.example.pjjava;

public class Order {
    private String table_ID;
    private String dish_ID;
    private Integer quantity;

    public Order() {
    }

    public Order(String table_ID, String dish_ID, Integer quantity) {
        this.table_ID = table_ID;
        this.dish_ID = dish_ID;
        this.quantity = quantity;
    }

    public String getTable_ID() {
        return table_ID;
    }

    public void setTable_ID(String table_ID) {
        this.table_ID = table_ID;
    }

    public String getDish_ID() {
        return dish_ID;
    }

    public void setDish_ID(String dish_ID) {
        this.dish_ID = dish_ID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "table_ID='" + table_ID + '\'' +
                ", dish_ID='" + dish_ID + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
