package com.asd.caselocationsmap.dao;

import com.asd.caselocationsmap.entity.Cases;
import java.sql.*;
import java.util.ArrayList;

public class ReadCasesSql {
    public ArrayList<Cases> select_all() {
        try {
            String username = "asd";
            String password = "Mypassword1@";
            String connectionUrl = "jdbc:mysql://103.149.46.76:3306/demodb";

            Connection conn = DriverManager.getConnection(connectionUrl, username, password);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM COVID19_Case;");
            ArrayList<Cases> array = new ArrayList<Cases>();

            while (rs.next()) {
                Cases cases = new Cases();
                cases.setId(rs.getString("case_id"));
                cases.setFirstName(rs.getString("first_name"));
                cases.setLastName(rs.getString("last_name"));
                cases.setCaseDate(rs.getDate("case_date"));
                cases.setLastUpdated(rs.getDate("last_updated"));
                cases.setPostcode(rs.getString("location_postcode"));
                cases.setSuburb(rs.getString("location_suburb"));
                cases.setLat(rs.getString("location_latitude"));
                cases.setLng(rs.getString("location_longitude"));
                cases.setLocation(rs.getString("location"));
                array.add(cases);
            }
            stmt.close();
            rs.close();
            conn.close();
            return array;
        } catch (SQLException e) {
            System.out.println("Error occurred at ReadCasesSql->select_all()");
            return new ArrayList<Cases>();
        }
    }
}
