package com.asd.caselocationsmap.dao;

import com.asd.caselocationsmap.entity.Cases;

import java.sql.*;

public class UpdateCasesSql {
    public void updateCases(Cases cases) {
        try{
            String username = "asd";
            String password = "Mypassword1@";
            String connectionUrl = "jdbc:mysql://103.149.46.76:3306/demodb";

            Connection conn = DriverManager.getConnection(connectionUrl, username, password);

            String sql = "update COVID19_Case set first_name = '"+cases.getFirstName()+"', last_name = '"+cases.getLastName()+"',case_date = '"+cases.getCaseDate()+"',last_updated = '"+cases.getLastUpdated()+"',location_postcode = '"+cases.getPostcode()+"',location_suburb = '"+cases.getSuburb()+"',location_latitude = '"+cases.getLat()+"',location_longitude = '"+cases.getLng()+"',location = '"+cases.getLocation()+"' where case_id = '"+cases.getId()+"'";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error occurred at updateCases()");
        }
    }
}
