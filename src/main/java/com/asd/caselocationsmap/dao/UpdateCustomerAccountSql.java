package com.asd.caselocationsmap.dao;

import com.asd.caselocationsmap.entity.CustomerAccount;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateCustomerAccountSql {
    public void updateCustomerAccount (CustomerAccount ca) {
        try {
            String username = "asd";
            String password = "ASDpassword";
            String connectionUrl = "jdbc:mysql://aa1k7pic2tpxd6q.cn9vqfnivxwa.us-east-2.rds.amazonaws.com:3306/CovidMap";
            Connection conn = DriverManager.getConnection(connectionUrl, username, password);
            String sql = "update Register set name = '"+ca.getName()+"', phone = '"+ca.getPhone()+"' where email = '"+ca.getEmail()+"'";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Error at customer update");
        }
    }
}
