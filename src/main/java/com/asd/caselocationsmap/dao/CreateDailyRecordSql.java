package com.asd.caselocationsmap.dao;

import com.asd.caselocationsmap.entity.DailyRecord;
import com.asd.caselocationsmap.entity.TestBooking;
import com.mysql.cj.protocol.Resultset;

import java.sql.*;

public class CreateDailyRecordSql {
    public DailyRecord createDailyRecord(DailyRecord dr) {
        try{
            String username = "asd";
            String password = "Mypassword1@";
            String connectionUrl = "jdbc:mysql://103.149.46.76:3306/demodb";
            Connection conn = DriverManager.getConnection(connectionUrl, username, password);
            //String sql = "Insert Into TestBooking(booking_id,fname,lname,strnum,str,suburb,email, phone, test_date, b_status, result) Values(default, '"+tb.getFname()+"','"+ tb.getLname()+"','"+tb.getStrnum()+"','"+ tb.getStr()+"','"+tb.getSuburb()+"','"+tb.getEmail()+"','"+ tb.getPhone()+"','"+ tb.getDate()+"','"+ tb.getStatus()+"','"+ tb.getResult()+"');";
            Statement stmt = conn.createStatement();
            String sql = "Insert Into DailyCOVIDRecord(record_id,new_case,deaths,cured_case,severe_case,total_case,publish_date) Values(default,"+dr.getNewCase()+","+dr.getDeaths()+","+dr.getCuredCase()+","+ dr.getSevere_case()+","+dr.getTotal_case()+",'"+dr.getPublishDate()+"')";
            stmt.executeUpdate(sql);
            sql = "Select * from DailyCOVIDRecord where record_id = (select  max(record_id) from DailyCOVIDRecord)";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                dr.setId(rs.getInt("record_id"));
            }
            conn.close();
            return dr;


        } catch (SQLException e) {
            System.out.println("Error occurred at ConSql->createDailyRecord");
            System.out.println(e);
            return new DailyRecord();

        }
    }
}
