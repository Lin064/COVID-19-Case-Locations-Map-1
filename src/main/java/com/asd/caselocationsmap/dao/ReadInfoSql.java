package com.asd.caselocationsmap.dao;

import com.asd.caselocationsmap.entity.Info;
import java.sql.*;
import java.util.ArrayList;

public class ReadInfoSql
{
    public ArrayList<Info> readAllInfo()
    {
        try {
            String username = "asd";
            String password = "ASDpassword";
            String connectionUrl = "jdbc:mysql://aa1k7pic2tpxd6q.cn9vqfnivxwa.us-east-2.rds.amazonaws.com:3306/CovidMap";

            Connection conn = DriverManager.getConnection(connectionUrl, username, password);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM COVID19_Info;");
            ArrayList<Info> array = new ArrayList<Info>();

            while (rs.next()) {
                Info info = new Info();
                info.setId(rs.getInt("info_id"));
                info.setTitle(rs.getString("info_title"));
                info.setDate(rs.getString("info_date"));
                info.setType(rs.getString("info_type"));
                info.setAuthor(rs.getString("info_author"));
                info.setDescription(rs.getString("info_description"));
                info.setContext(rs.getString("info_context"));
                info.setStatus(rs.getBoolean("info_status"));
                array.add(info);
            }
            stmt.close();
            rs.close();
            conn.close();
            System.out.println("[Hint] Get All Records From Database Successful!");
            return array;
        } catch (SQLException e) {
            System.out.println("[Hint] Error occurred at ReadCasesSql->readAllInfo()\n" + e);
            return new ArrayList<Info>();
        }
    }

    public ArrayList<Info> readInfo(int id)
    {
        try {
            String username = "asd";
            String password = "ASDpassword";
            String connectionUrl = "jdbc:mysql://aa1k7pic2tpxd6q.cn9vqfnivxwa.us-east-2.rds.amazonaws.com:3306/CovidMap";

            Connection conn = DriverManager.getConnection(connectionUrl, username, password);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM COVID19_Info where info_id = " + id + ";");
            ArrayList<Info> array = new ArrayList<Info>();

            while (rs.next()) {
                Info info = new Info();
                info.setId(rs.getInt("info_id"));
                info.setTitle(rs.getString("info_title"));
                info.setDate(rs.getString("info_date"));
                info.setType(rs.getString("info_type"));
                info.setAuthor(rs.getString("info_author"));
                info.setDescription(rs.getString("info_description"));
                info.setContext(rs.getString("info_context"));
                info.setStatus(rs.getBoolean("info_status"));
                array.add(info);
            }
            stmt.close();
            rs.close();
            conn.close();
            System.out.println("[Hint] Get Record From Database Successful!");
            return array;
        } catch (SQLException e) {
            System.out.println("[Hint] Error occurred at ReadCasesSql->readInfo()\n" + e);
            return new ArrayList<Info>();
        }
    }
}
