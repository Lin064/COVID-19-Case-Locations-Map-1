package com.asd.caselocationsmap.dao;

import com.asd.caselocationsmap.entity.TestBooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTestBookingSql {
    public void updateTestBooking(TestBooking tb) {
        try {
            String username = "asd";
            String password = "Mypassword1@";
            String connectionUrl = "jdbc:mysql://103.149.46.76:3306/demodb";
            Connection conn = DriverManager.getConnection(connectionUrl, username, password);
            String sql = "Update TestBooking SET fname = '" + tb.getFname() + "',lname = '" + tb.getLname() + "',strnum = '" + tb.getStrnum() + "',str = '" + tb.getStr() + "',suburb='" + tb.getSuburb() + "',email='" + tb.getEmail() + "',phone='" + tb.getPhone() + "',test_date='" + tb.getDate() + "',b_status='" + tb.getStatus() + "',result='" + tb.getResult() + "' Where booking_id =" + tb.getId() + ";";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error occurred at updateBooking()");
        }
    }
}
