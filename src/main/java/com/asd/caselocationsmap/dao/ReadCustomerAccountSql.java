package com.asd.caselocationsmap.dao;


import com.asd.caselocationsmap.entity.CustomerAccount;

import java.sql.*;
import java.util.ArrayList;

public class ReadCustomerAccountSql {
    public boolean verifyAccount(CustomerAccount ca){
        try {
            String username = "asd";
            String password = "Mypassword1@";
            String connectionUrl = "jdbc:mysql://103.149.46.76:3306/demodb";
            Connection conn = DriverManager.getConnection(connectionUrl, username, password);
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM Register Where email ='"+ca.getEmail()+"';" ;
            String   password1 = ca.getPassword();
            String  dbPwd = "";
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
            System.out.println(e);
            return false;
        }
    }
}
