package com.example.javafxemailclient.controller.persistence;

import java.io.Serializable;

public class VaildAccount implements Serializable {

    private String address;
    private String password;

    public VaildAccount(String address, String password) {
        this.address = address;
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
