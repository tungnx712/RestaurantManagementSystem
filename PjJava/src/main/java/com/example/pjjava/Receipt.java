package com.example.pjjava;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Receipt {
    private String clientName;
    private String clientPhone;
    private String clientDob;
    private Date date;
    private int tableId;
    private List<ReceiptItem> receiptItems;
    private double total;

    public Receipt(String clientName, String clientPhone, String clientDob, Date date, int tableId, List<ReceiptItem> receiptItems, double total) {
        this.clientName = clientName;
        this.clientPhone = clientPhone;
        this.clientDob = clientDob;
        this.date = date;
        this.tableId = tableId;
        this.receiptItems = receiptItems;
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

    public List<ReceiptItem> getReceiptItems() {
        return receiptItems;
    }

    public void setReceiptItems(List<ReceiptItem> receiptItems) {
        this.receiptItems = receiptItems;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n\t\tReceipt");
        sb.append("\nClient: ").append(clientName);
        sb.append("\nPhone: ").append(clientPhone);
        sb.append("\nD.O.B: ").append(clientDob);
        sb.append("\nDate: ").append(date);
        sb.append("\nTable: ").append(tableId);

        sb.append("\n\t\t|-----------------|-----------------|-----------------|");
        sb.append("\n\t\t|      Dish       |    Quantity     |    Dish Price   |");
        sb.append("\n\t\t|-----------------|-----------------|-----------------|");

        for (ReceiptItem item : receiptItems) {
            sb.append("\n\t\t| ");
            sb.append(String.format("%-16s", item.getDishName()));
            sb.append("| ");
            sb.append(String.format("%-16s", item.getQuantity()));
            sb.append("| ");
            sb.append(String.format("%-16s", item.getPrice()));
            sb.append("|");
        }
        sb.append("\n\t\t|-----------------|-----------------|-----------------|");
        sb.append("\n\t\t|-----------------|-----------------|TOTAL: ").append(total);
        return sb.toString();
    }
}
