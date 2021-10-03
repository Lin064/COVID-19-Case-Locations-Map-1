package com.asd.caselocationsmap.entity;


public class vaccInjectLocation {
    private int Id;
    private String vaccStreet;
    private String vaccSuburb;
    private String isAvailable;
    private int remainingVaccine;
    private String locationName;
    private String bookingWebsite;
    private String bookingTel;
    private String locationLongitude;
    private String locationLatitude;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getVaccStreet() {
        return vaccStreet;
    }

    public void setVaccStreet(String vaccStreet) {
        this.vaccStreet = vaccStreet;
    }

    public String getVaccSuburb() {
        return vaccSuburb;
    }

    public void setVaccSuburb(String vaccSuburb) {
        this.vaccSuburb = vaccSuburb;
    }

    public String getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
    }

    public int getRemainingVaccine() {
        return remainingVaccine;
    }

    public void setRemainingVaccine(int remainingVaccine) {
        this.remainingVaccine = remainingVaccine;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getBookingWebsite() {
        return bookingWebsite;
    }

    public void setBookingWebsite(String bookingWebsite) {
        this.bookingWebsite = bookingWebsite;
    }

    public String getBookingTel() {
        return bookingTel;
    }

    public void setBookingTel(String bookingTel) {
        this.bookingTel = bookingTel;
    }

    public String getLocationLongitude() {return locationLongitude;}

    public void setLocationLongitude(String locationLongitude) {
        this.locationLongitude = locationLongitude;
    }

    public String getLocationLatitude() {
        return locationLatitude;
    }

    public void setLocationLatitude(String locationLatitude) {
        this.locationLatitude = locationLatitude;
    }
}
