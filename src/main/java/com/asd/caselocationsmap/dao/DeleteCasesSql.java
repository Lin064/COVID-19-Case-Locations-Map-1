package com.asd.caselocationsmap.dao;

import java.sql.*;

public class DeleteCasesSql {
    public void removeCases(String id) {
        try{
            String username = "asd";
            String password = "ASDpassword";
            String connectionUrl = "jdbc:mysql://aa1k7pic2tpxd6q.cn9vqfnivxwa.us-east-2.rds.amazonaws.com:3306/CovidMap";

            Connection conn = DriverManager.getConnection(connectionUrl, username, password);

            String sql = "delete from COVID19_Case where case_id = '"+id+"'";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error occurred at removeCases()");
        }
    }
}
