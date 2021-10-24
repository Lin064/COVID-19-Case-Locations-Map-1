package com.asd.caselocationsmap.dao;

import com.asd.caselocationsmap.entity.DailyRecord;
import com.asd.caselocationsmap.entity.TestBooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDailyRecordSql {
    public void updateDailyRecord(DailyRecord dr) {
        try {
            String username = "asd";
            String password = "ASDpassword";
            String connectionUrl = "jdbc:mysql://aa1k7pic2tpxd6q.cn9vqfnivxwa.us-east-2.rds.amazonaws.com:3306/CovidMap";
            Connection conn = DriverManager.getConnection(connectionUrl, username, password);
            Statement stmt = conn.createStatement();
            String sql = "Update DailyCOVIDRecord SET new_case = "+dr.getNewCase()+",deaths="+dr.getDeaths()+",cured_case="+dr.getCuredCase()+",severe_case="+dr.getSevere_case()+",total_case="+dr.getTotal_case()+",publish_date='"+dr.getPublishDate()+"' where record_id=+"+dr.getId()+";";
            stmt.executeUpdate(sql);
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error occurred at updateDailyRecord()");
            System.out.println(e);
        }
    }
}
