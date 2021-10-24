package com.asd.caselocationsmap.dao;


import com.asd.caselocationsmap.entity.CustomerAccount;
import com.asd.caselocationsmap.entity.StaffAccount;

import java.sql.*;
import java.util.ArrayList;

public class ReadCustomerAccountSql {

    public CustomerAccount customerAccount (String email){
        try {
            String username = "asd";
            String password = "ASDpassword";
            String connectionUrl = "jdbc:mysql://aa1k7pic2tpxd6q.cn9vqfnivxwa.us-east-2.rds.amazonaws.com/CovidMap";
            Connection conn = DriverManager.getConnection(connectionUrl, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Register where email = '"+ email+"'");
            CustomerAccount cas = new CustomerAccount();

            while(rs.next()) {
                cas.setEmail(rs.getString("email"));
                cas.setName(rs.getString("name"));
                cas.setPhone(rs.getString("phone"));
            }
            stmt.close();
            rs.close();
            conn.close();
            System.out.println("success");
            return cas;

        } catch (SQLException e) {
            System.out.println("Error occurred at ReadCustomerAccountSql"+e);
            return new CustomerAccount();
        }
    }

    public boolean verifyAccount(CustomerAccount ca){
        try {
            String username = "asd";
            String password = "Mypassword1@";
            String connectionUrl = "jdbc:mysql://103.149.46.76:3306/demodb";
            Connection conn = DriverManager.getConnection(connectionUrl, username, password);
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM Register Where email ='"+ca.getEmail()+"';" ;
            String password1 = ca.getPassword();
            String dbPwd = "";
            ResultSet rs = stmt.executeQuery(sql);
            int i = 0;
            while (rs.next()) {
                dbPwd = rs.getString("password");
                i++;
            }
            if (i==0){
                stmt.close();
                rs.close();
                conn.close();
                return false;
            }
            stmt.close();
            rs.close();
            conn.close();
            if(dbPwd.equals(password1)){
                return true;
            }
            return  false;
        } catch (SQLException e) {
            System.out.println("Error occurred at CustomerAccount->verify()");
            return false;
        }
    }
}
