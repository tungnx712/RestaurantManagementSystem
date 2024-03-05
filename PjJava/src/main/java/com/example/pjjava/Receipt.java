package com.example.pjjava;

import java.time.LocalDate;
import java.util.Date;

public class Receipt {
    private String clientName;
    private String clientPhone;
    private String clientDob;
    private Date date;
    private int tableId;
    private String dishName;
    private int quantity;
    private double dishPrice;
    private double total;

    public Receipt(String clientName, String phone, Date dob, LocalDate now, int tableId, String dishName, int quantity, double dishPrice, double total) {
    }

    public Receipt(String clientName, String clientPhone, String clientDob, Date date, int tableId, String dishName, int quantity, double dishPrice, double total) {
        this.clientName = clientName;
        this.clientPhone = clientPhone;
        this.clientDob = clientDob;
        this.date = date;
        this.tableId = tableId;
        this.dishName = dishName;
        this.quantity = quantity;
        this.dishPrice = dishPrice;
        this.total = total;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public String getClientDob() {
        return clientDob;
    }

    public void setClientDob(String clientDob) {
        this.clientDob = clientDob;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
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

    public double getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(double dishPrice) {
        this.dishPrice = dishPrice;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    @Override
    public String toString() {
        return "\n\n\t\tReceipt" +
                "\nClient: " + clientName +
                "\nPhone: " + clientPhone +
                "\nD.O.B: " + clientDob +
                "\nDate: " + date +
                "\nTable: " + tableId +
                "\nDish: " + dishName +
                "\tQuantity: " + quantity +
                "\tDish Price: " + dishPrice +
                "\n\tTOTAL: " + total;
    }
}
