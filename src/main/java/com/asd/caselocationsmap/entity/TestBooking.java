package com.asd.caselocationsmap.entity;

import java.util.Date;

public class TestBooking {
    private int id;
    private String fname;
    private String lname;
    private String strnum;
    private String str;
    private String suburb;
    private String email;
    private String phone;
    private String date;
    private String status;
    private String result;

    public int getId() {
        return id;
    }

    public String getResult() {
        return result;
    }

    public String getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }

    public String getEmail() {
        return email;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getPhone() {
        return phone;
    }

    public String getStr() {
        return str;
    }

    public String getStrnum() {
        return strnum;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public void setStrnum(String strnum) {
        this.strnum = strnum;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setResult(String result) {
        this.result = result;
    }
}