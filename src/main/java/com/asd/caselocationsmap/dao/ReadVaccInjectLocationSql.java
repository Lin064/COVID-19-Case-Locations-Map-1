package com.asd.caselocationsmap.dao;

import com.asd.caselocationsmap.entity.vaccInjectLocation;

import java.sql.*;
import java.util.ArrayList;

public class ReadVaccInjectLocationSql {
    public ArrayList<vaccInjectLocation> select_all() {
        try {
            String username = "asd";
            String password = "Mypassword1@";
            String connectionUrl = "jdbc:mysql://103.149.46.76:3306/demodb";

            Connection conn = DriverManager.getConnection(connectionUrl, username, password);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM VaccInjectLocation;");
            ArrayList<vaccInjectLocation> array = new ArrayList<vaccInjectLocation>();

            while (rs.next()) {
                vaccInjectLocation vaccInjectLocation = new vaccInjectLocation();
                vaccInjectLocation.setId(rs.getInt("location_id"));
                vaccInjectLocation.setVaccStreet(rs.getString("vacc_street"));
                vaccInjectLocation.setVaccSuburb(rs.getString("vacc_suburb"));
                vaccInjectLocation.setIsAvailable(rs.getString("is_available"));
                vaccInjectLocation.setRemainingVaccine(rs.getInt("remaining_vaccine"));
                vaccInjectLocation.setLocationName(rs.getString("location_name"));
                vaccInjectLocation.setBookingWebsite(rs.getString("booking_website"));
                vaccInjectLocation.setBookingTel(rs.getString("booking_tel"));
                vaccInjectLocation.setLocationLongitude(rs.getString("location_longitude"));
                vaccInjectLocation.setLocationLatitude(rs.getString("location_latitude"));
                array.add(vaccInjectLocation);
            }
            stmt.close();
            rs.close();
            conn.close();
            return array;
        } catch (SQLException e) {
            System.out.println("Error occurred at ReadCasesSql->select_all()");
            return new ArrayList<vaccInjectLocation>();
        }
    }
}
