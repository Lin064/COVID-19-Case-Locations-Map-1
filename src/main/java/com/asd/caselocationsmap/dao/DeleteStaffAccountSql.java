package com.asd.caselocationsmap.dao;
import java.sql.*;

public class DeleteStaffAccountSql {
    public void deleteAccount(int id) {
        try {
            String username = "asd";
            String password = "ASDpassword";
            String connectionUrl = "jdbc:mysql://aa1k7pic2tpxd6q.cn9vqfnivxwa.us-east-2.rds.amazonaws.com/CovidMap";
            Connection conn = DriverManager.getConnection(connectionUrl, username, password);

            String sql = "delete from StaffAccount where staffid = '"+id+"'";
            System.out.println("account is found");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error at deleteAccount()");
        }
    }
}
