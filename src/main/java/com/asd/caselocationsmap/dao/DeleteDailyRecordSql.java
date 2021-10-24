package com.asd.caselocationsmap.dao;

import com.asd.caselocationsmap.entity.DailyRecord;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteDailyRecordSql {
    public void removeDailyRecord(DailyRecord dr) {
        try{
            String username = "asd";
            String password = "ASDpassword";
            String connectionUrl = "jdbc:mysql://aa1k7pic2tpxd6q.cn9vqfnivxwa.us-east-2.rds.amazonaws.com:3306/CovidMap";
            Connection conn = DriverManager.getConnection(connectionUrl, username, password);
            String sql = "delete from DailyCOVIDRecord where record_id = "+dr.getId()+";";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error occurred at removeDailyRecord()");
        }
    }

}
