package com.asd.caselocationsmap.entity;


public class covidPtl {
    private int Id;
    private String ptlStreet;
    private String ptlSuburb;
    private int openTime;
    private int closeTime;
    private String ptlName;
    private String ptlTel;
    private String ptlLongitude;
    private String ptlLatitude;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getPtlStreet() {
        return ptlStreet;
    }

    public void setPtlStreet(String ptlStreet) {
        this.ptlStreet = ptlStreet;
    }

    public String getPtlSuburb() {
        return ptlSuburb;
    }

    public void setPtlSuburb(String ptlSuburb) {
        this.ptlSuburb = ptlSuburb;
    }

    public int getOpenTime() {
        return openTime;
    }

    public void setOpenTime(int openTime) {
        this.openTime = openTime;
    }

    public int getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(int closeTime) {
        this.closeTime = closeTime;
    }

    public String getPtlName() {
        return ptlName;
    }

    public void setPtlName(String ptlName) {
        this.ptlName = ptlName;
    }

    public String getPtlTel() {
        return ptlTel;
    }

    public void setPtlTel(String ptlTel) {
        this.ptlTel = ptlTel;
    }

    public String getPtlLongitude() {return ptlLongitude;}

    public void setPtlLongitude(String ptlLongitude) {
        this.ptlLongitude = ptlLongitude;
    }

    public String getPtlLatitude() {
        return ptlLatitude;
    }

    public void setPtlLatitude(String ptlLatitude) {
        this.ptlLatitude = ptlLatitude;
    }
}
