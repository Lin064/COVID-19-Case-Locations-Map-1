package com.asd.caselocationsmap.dao;
import com.asd.caselocationsmap.entity.TestBooking;

import java.sql.*;
import java.util.ArrayList;

public class ReadTestBookingSql {


    public ArrayList<TestBooking> selectBySuburb(String suburb){
        try {
            String username = "asd";
            String password = "ASDpassword";
            String connectionUrl = "jdbc:mysql://aa1k7pic2tpxd6q.cn9vqfnivxwa.us-east-2.rds.amazonaws.com/CovidMap";
            Connection conn = DriverManager.getConnection(connectionUrl, username, password);
            Statement stmt = conn.createStatement();
            String sql ="SELECT * FROM TestBooking Where Suburb Like '%"+suburb +"%';";
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<TestBooking> array = new ArrayList<TestBooking>();
            while (rs.next()) {
                TestBooking tb = new TestBooking();
                tb.setId(rs.getInt("booking_id"));
                tb.setFname(rs.getString("fname"));
                tb.setLname(rs.getString("lname"));
                tb.setStrnum(rs.getString("strnum"));
                tb.setStr(rs.getString("str"));
                tb.setSuburb(rs.getString("suburb"));
                tb.setEmail(rs.getString("email"));
                tb.setPhone(rs.getString("phone"));
                tb.setDate(rs.getString("test_date"));
                tb.setStatus(rs.getString("b_status"));
                tb.setResult(rs.getString("result"));
                array.add(tb);
            }
            stmt.close();
            rs.close();
            conn.close();
            return array;
        } catch (SQLException e) {
            System.out.println("Error occurred at ReadTestBooking->selectBySuburb()");
            return new ArrayList<TestBooking>();
        }
    }

    public ArrayList<TestBooking> selectByEmail(String email){
        try {
            String username = "asd";
            String password = "Mypassword1@";
            String connectionUrl = "jdbc:mysql://103.149.46.76:3306/demodb";
            Connection conn = DriverManager.getConnection(connectionUrl, username, password);
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM TestBooking Where email ='"+email+"';";
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<TestBooking> array = new ArrayList<TestBooking>();
            while (rs.next()) {
                TestBooking tb = new TestBooking();
                tb.setId(rs.getInt("booking_id"));
                tb.setFname(rs.getString("fname"));
                tb.setLname(rs.getString("lname"));
                tb.setStrnum(rs.getString("strnum"));
                tb.setStr(rs.getString("str"));
                tb.setSuburb(rs.getString("suburb"));
                tb.setEmail(email);
                tb.setPhone(rs.getString("phone"));
                tb.setDate(rs.getString("test_date"));
                tb.setStatus(rs.getString("b_status"));
                tb.setResult(rs.getString("result"));
                array.add(tb);
            }
            stmt.close();
            rs.close();
            conn.close();
            return array;
        } catch (SQLException e) {
            System.out.println("Error occurred at ReadTestBooking->selectByemail()");
            return new ArrayList<TestBooking>();
        }
    }

    public TestBooking selectById(int id){
        try {
            String username = "asd";
            String password = "Mypassword1@";
            String connectionUrl = "jdbc:mysql://103.149.46.76:3306/demodb";
            Connection conn = DriverManager.getConnection(connectionUrl, username, password);
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM TestBooking Where booking_id ="+id+";";
            // select * from testBooking where booking_id = id);
            TestBooking tb = new TestBooking();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                tb.setId(id);
                tb.setFname(rs.getString("fname"));
                tb.setLname(rs.getString("lname"));
                tb.setStrnum(rs.getString("strnum"));
                tb.setStr(rs.getString("str"));
                tb.setSuburb(rs.getString("suburb"));
                tb.setEmail(rs.getString("email"));
                tb.setPhone(rs.getString("phone"));
                tb.setDate(rs.getString("test_date"));
                tb.setStatus(rs.getString("b_status"));
                tb.setResult(rs.getString("result"));
            }
            stmt.close();
            rs.close();
            conn.close();
            return tb;
        } catch (SQLException e) {
            System.out.println("Error occurred at ReadTestBooking->selectById() ");
            return new TestBooking();
        }
    }

    public ArrayList<TestBooking> select_all() {
        try {
            String username = "asd";
            String password = "Mypassword1@";
            String connectionUrl = "jdbc:mysql://103.149.46.76:3306/demodb";
            Connection conn = DriverManager.getConnection(connectionUrl, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM TestBooking;");
            ArrayList<TestBooking> array = new ArrayList<TestBooking>();

            while (rs.next()) {
                TestBooking tb = new TestBooking();
                tb.setId(rs.getInt("booking_id"));
                tb.setFname(rs.getString("fname"));
                tb.setLname(rs.getString("lname"));
                tb.setStrnum(rs.getString("strnum"));
                tb.setStr(rs.getString("str"));
                tb.setSuburb(rs.getString("suburb"));
                tb.setEmail(rs.getString("email"));
                tb.setPhone(rs.getString("phone"));
                tb.setDate(rs.getString("test_date"));
                tb.setStatus(rs.getString("b_status"));
                tb.setResult(rs.getString("result"));
                array.add(tb);
            }
            stmt.close();
            rs.close();
            conn.close();
            return array;
        } catch (SQLException e) {
            System.out.println("Error occurred at ReadTestBooking->select_all()");
            return new ArrayList<TestBooking>();
        }
    }
}
