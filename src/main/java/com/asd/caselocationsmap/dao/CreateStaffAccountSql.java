package com.asd.caselocationsmap.dao;
import com.asd.caselocationsmap.entity.StaffAccount;
import java.sql.*;

public class CreateStaffAccountSql {

    public void createStaffAccount(StaffAccount staffaccount) {
        try{
            String username = "asd";
            String password = "Mypassword1@";
            String connectionUrl = "jdbc:mysql://103.149.46.76:3306/demodb";
            Connection conn = DriverManager.getConnection(connectionUrl, username, password);

            String sql = "insert into StaffAccount (staffid, staffemail, staffpassword) values (default, '" +staffaccount.getStaffEmail()+"', '"+staffaccount.getStaffPassword()+"');";;
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error occurred at ConSql->createAccount()");
        }

    }

}