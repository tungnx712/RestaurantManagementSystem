package com.example.pjjava;

import java.sql.Date;

public class ClientData {
    private Integer client_ID;
    private String client_name;
    private String phone;
    private Date dob;

    public ClientData() {
    }

    public ClientData(Integer client_ID, String client_name, String phone, Date dob) {
        this.client_ID = client_ID;
        this.client_name = client_name;
        this.phone = phone;
        this.dob = dob;
    }

    public Integer getClient_ID() {
        return client_ID;
    }

    public void setClient_ID(Integer client_ID) {
        this.client_ID = client_ID;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
