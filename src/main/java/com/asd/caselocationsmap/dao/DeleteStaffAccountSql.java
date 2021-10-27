package com.asd.caselocationsmap.dao;
import java.sql.*;

public class DeleteStaffAccountSql {
    public void deleteAccount(int id) {
        try {
            String username = "asd";
            String password = "Mypassword1@";
            String connectionUrl = "jdbc:mysql://103.149.46.76:3306/demodb";
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
