package com.asd.caselocationsmap.dao;

import com.asd.caselocationsmap.entity.covidPtl;

import java.sql.*;
import java.util.ArrayList;

public class ReadCovidptlSql {
    public ArrayList<covidPtl> select_all() {
        try {
            String username = "asd";
            String password = "ASDpassword";
            String connectionUrl = "jdbc:mysql://aa1k7pic2tpxd6q.cn9vqfnivxwa.us-east-2.rds.amazonaws.com:3306/CovidMap";

            Connection conn = DriverManager.getConnection(connectionUrl, username, password);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Covid19_PublicTestLocation;");
            ArrayList<covidPtl> array = new ArrayList<covidPtl>();

            while (rs.next()) {
                covidPtl covidPtl = new covidPtl();
                covidPtl.setId(rs.getInt("testLocation_id"));
                covidPtl.setPtlStreet(rs.getString("ptl_street"));
                covidPtl.setPtlSuburb(rs.getString("ptl_suburb"));
                covidPtl.setOpenTime(rs.getInt("open_time"));
                covidPtl.setCloseTime(rs.getInt("close_time"));
                covidPtl.setPtlName(rs.getString("ptl_name"));
                covidPtl.setPtlTel(rs.getString("ptl_tel"));
                covidPtl.setPtlLongitude(rs.getString("ptl_longitude"));
                covidPtl.setPtlLatitude(rs.getString("ptl_latitude"));
                array.add(covidPtl);
            }
            stmt.close();
            rs.close();
            conn.close();
            return array;
        } catch (SQLException e) {
            System.out.println("Error occurred at ReadCovidptlSql->select_all()");
            return new ArrayList<covidPtl>();
        }
    }
}
