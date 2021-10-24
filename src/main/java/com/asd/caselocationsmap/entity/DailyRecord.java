package com.asd.caselocationsmap.entity;

public class DailyRecord {
    private int id;
    private int newCase;
    private int deaths;
    private int curedCase;
    private int severe_case;
    private int total_case;
    private String publishDate;
    public int getId(){
        return id;
    }

    public int getCuredCase() {
        return curedCase;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getNewCase() {
        return newCase;
    }

    public int getSevere_case() {
        return severe_case;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public int getTotal_case() {
        return total_case;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCuredCase(int curedCase) {
        this.curedCase = curedCase;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public void setNewCase(int newCase) {
        this.newCase = newCase;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public void setSevere_case(int severe_case) {
        this.severe_case = severe_case;
    }

    public void setTotal_case(int total_case) {
        this.total_case = total_case;
    }

}
