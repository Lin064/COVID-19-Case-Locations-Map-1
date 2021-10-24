package com.asd.caselocationsmap.dao;

import com.asd.caselocationsmap.entity.DailyRecord;
import com.asd.caselocationsmap.entity.TestBooking;

import java.sql.*;
import java.util.ArrayList;

public class ReadDailyRecordSql {
    public ArrayList<DailyRecord> getDailyRecord() {
        try {
            String username = "asd";
            String password = "ASDpassword";
            String connectionUrl = "jdbc:mysql://aa1k7pic2tpxd6q.cn9vqfnivxwa.us-east-2.rds.amazonaws.com/CovidMap";
            Connection conn = DriverManager.getConnection(connectionUrl, username, password);
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM DailyCOVIDRecord;";
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList<DailyRecord> array = new ArrayList<DailyRecord>();
            while (rs.next()) {
                DailyRecord dr = new DailyRecord();
                dr.setId(rs.getInt("record_id"));
                dr.setNewCase(rs.getInt("new_case"));
                dr.setDeaths(rs.getInt("deaths"));
                dr.setCuredCase(rs.getInt("cured_case"));
                dr.setSevere_case(rs.getInt("severe_case"));
                dr.setTotal_case(rs.getInt("total_case"));
                dr.setPublishDate(rs.getString("publish_date"));
                array.add(dr);
            }
            stmt.close();
            rs.close();
            conn.close();
            return array;
        } catch (SQLException e) {
            System.out.println("Error occurred at ReadDailyRecord()");
            System.out.println(e);
            return new ArrayList<DailyRecord>();
        }
    }

    public DailyRecord getDailyRecordbyDate(String date) {
        try {
            String username = "asd";
            String password = "Mypassword1@";
            String connectionUrl = "jdbc:mysql://103.149.46.76:3306/demodb";
            Connection conn = DriverManager.getConnection(connectionUrl, username, password);
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM DailyCOVIDRecord where publish_date = '"+date+"'";
            ResultSet rs = stmt.executeQuery(sql);
            DailyRecord dr = new DailyRecord();
            while (rs.next()) {
                dr.setId(rs.getInt("record_id"));
                dr.setNewCase(rs.getInt("new_case"));
                dr.setDeaths(rs.getInt("deaths"));
                dr.setCuredCase(rs.getInt("cured_case"));
                dr.setSevere_case(rs.getInt("severe_case"));
                dr.setTotal_case(rs.getInt("total_case"));
                dr.setPublishDate(rs.getString("publish_date"));
            }
            stmt.close();
            rs.close();
            conn.close();
            return dr;
        } catch (SQLException e) {
            System.out.println("Error occurred at ReadDailyRecord()");
            System.out.println(e);
            return new DailyRecord();
        }
    }

    public DailyRecord getLatestDailyRecord() {
        try {
            String username = "asd";
            String password = "Mypassword1@";
            String connectionUrl = "jdbc:mysql://103.149.46.76:3306/demodb";
            Connection conn = DriverManager.getConnection(connectionUrl, username, password);
            Statement stmt = conn.createStatement();

            String sql = "select * from DailyCOVIDRecord where publish_date = (select max(publish_date) from DailyCOVIDRecord)";
            ResultSet rs = stmt.executeQuery(sql);
            DailyRecord dr = new DailyRecord();
            while (rs.next()) {
                dr.setId(rs.getInt("record_id"));
                dr.setNewCase(rs.getInt("new_case"));
                dr.setDeaths(rs.getInt("deaths"));
                dr.setCuredCase(rs.getInt("cured_case"));
                dr.setSevere_case(rs.getInt("severe_case"));
                dr.setTotal_case(rs.getInt("total_case"));
                dr.setPublishDate(rs.getString("publish_date"));
            }
            stmt.close();
            rs.close();
            conn.close();
            return dr;
        } catch (SQLException e) {
            System.out.println("Error occurred at ReadDailyRecord()");
            System.out.println(e);
            return new DailyRecord();
        }
    }

    public DailyRecord getDailyRecordbyId(int id) {
        try {
            String username = "asd";
            String password = "Mypassword1@";
            String connectionUrl = "jdbc:mysql://103.149.46.76:3306/demodb";
            Connection conn = DriverManager.getConnection(connectionUrl, username, password);
            Statement stmt = conn.createStatement();

            String sql = "SELECT * FROM DailyCOVIDRecord where record_id = "+id+"";
            ResultSet rs = stmt.executeQuery(sql);
            DailyRecord dr = new DailyRecord();
            while (rs.next()) {
                dr.setId(rs.getInt("record_id"));
                dr.setNewCase(rs.getInt("new_case"));
                dr.setDeaths(rs.getInt("deaths"));
                dr.setCuredCase(rs.getInt("cured_case"));
                dr.setSevere_case(rs.getInt("severe"));
                dr.setTotal_case(rs.getInt("total_case"));
                dr.setPublishDate(rs.getString("publish_date"));
            }
            stmt.close();
            rs.close();
            conn.close();
            return dr;
        } catch (SQLException e) {
            System.out.println("Error occurred at ReadDailyRecord()");
            return new DailyRecord();
        }
    }



}
