package com.asd.caselocationsmap.dao;

import com.asd.caselocationsmap.entity.vaccInjectLocation;

import java.sql.*;

public class CreateVaccInjectLocationSQL {
    public void createVaccInjectLocation(vaccInjectLocation tb) {
        try{
            String username = "asd";
            String password = "Mypassword1@";
            String connectionUrl = "jdbc:mysql://103.149.46.76:3306/demodb";

            Connection conn = DriverManager.getConnection(connectionUrl, username, password);

            String sql = "insert into VaccInjectLocation (location_Id, vacc_street, vacc_suburb, is_available, remaining_vaccine, location_name,booking_website, booking_tel, location_longitude, location_latitude) values ('"+tb.getId()+"', '"+tb.getVaccStreet()+"', '"+tb.getVaccSuburb()+"', '"+tb.getIsAvailable()+"', '"+tb.getRemainingVaccine()+"', '"+tb.getLocationName()+"', '"+tb.getBookingWebsite()+"', '"+tb.getBookingTel()+"', '"+tb.getLocationLongitude()+"', '"+tb.getLocationLatitude()+"');";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error occurred at ConSql->createvaccInjectLocation()");
        }
    }
}