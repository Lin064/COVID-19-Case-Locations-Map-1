package com.asd.caselocationsmap.dao;



import com.asd.caselocationsmap.entity.covidPtl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateCovidptlSql {
    public void updatecovidPtl(covidPtl covidPtl) {
        try{
            String username = "asd";
            String password = "ASDpassword";
            String connectionUrl = "jdbc:mysql://aa1k7pic2tpxd6q.cn9vqfnivxwa.us-east-2.rds.amazonaws.com:3306/CovidMap";

            Connection conn = DriverManager.getConnection(connectionUrl, username, password);

            String sql = "update Covid19_PublicTestLocation set ptl_street = '"+covidPtl.getPtlStreet()+"', ptl_suburb = '"+covidPtl.getPtlSuburb()+"',open_time = '"+covidPtl.getOpenTime()+"',close_time = '"+covidPtl.getCloseTime()+"',ptl_name = '"+covidPtl.getPtlName()+"',ptl_tel = '"+covidPtl.getPtlTel()+"',ptl_longitude = '"+covidPtl.getPtlLongitude()+"',ptl_latitude = '"+covidPtl.getPtlLatitude()+"' where testLocation_id = '"+covidPtl.getId()+"'";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error occurred at updateCovidPtl()");
        }
    }
}
