package com.asd.caselocationsmap.dao;

import com.asd.caselocationsmap.entity.Cases;
import com.asd.caselocationsmap.entity.TestBooking;

import java.sql.*;

public class CreateTestBookingSql {
    public void createTestBooking(TestBooking tb) {
        try{
            String username = "asd";
            String password = "ASDpassword";
            String connectionUrl = "jdbc:mysql://aa1k7pic2tpxd6q.cn9vqfnivxwa.us-east-2.rds.amazonaws.com:3306/CovidMap";
            Connection conn = DriverManager.getConnection(connectionUrl, username, password);
            String sql = "Insert Into TestBooking(booking_id,fname,lname,strnum,str,suburb,email, phone, test_date, b_status, result) Values(default, '"+tb.getFname()+"','"+ tb.getLname()+"','"+tb.getStrnum()+"','"+ tb.getStr()+"','"+tb.getSuburb()+"','"+tb.getEmail()+"','"+ tb.getPhone()+"','"+ tb.getDate()+"','"+ tb.getStatus()+"','"+ tb.getResult()+"');";
                    /*
                      Insert into (booking_id,fname,lname,strnum,str,suburb,email, phone, test_date, b_status, result)
                      values(default,tb.fname,tb.lname,tb.strnum,tb.str,tb.suburb,tb.email,tb.phone, tb.)
                     */
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error occurred at ConSql->createTestBooking()");

        }
    }
}
