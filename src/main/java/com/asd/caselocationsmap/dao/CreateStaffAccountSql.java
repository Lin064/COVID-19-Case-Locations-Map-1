package com.asd.caselocationsmap.dao;
import com.asd.caselocationsmap.entity.StaffAccount;
import java.sql.*;

public class CreateStaffAccountSql {
    public boolean checkEmailExistence(String email){
        try{
            String username = "asd";
            String password = "ASDpassword";
            String connectionUrl = "jdbc:mysql://aa1k7pic2tpxd6q.cn9vqfnivxwa.us-east-2.rds.amazonaws.com/CovidMap";
            Connection conn = DriverManager.getConnection(connectionUrl, username, password);

            String sql = "Select * from StaffAccount where staffemail='"+email+"'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            int i = 0;
            while(rs.next()){
                i++;
            }
            if(i!=0){
                conn.close();
                return false;
            }
            conn.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error occurred at ConSql->createAccount()");
            return false;
        }
    }
    public boolean createStaffAccount(StaffAccount staffaccount) {
        try{
            String username = "asd";
            String password = "Mypassword1@";
            String connectionUrl = "jdbc:mysql://103.149.46.76:3306/demodb";
            Connection conn = DriverManager.getConnection(connectionUrl, username, password);
            if (!checkEmailExistence(staffaccount.getStaffEmail())){
                conn.close();
                return false;
            }
            String sql = "insert into StaffAccount (staffid, staffemail, staffpassword) values (default, '" +staffaccount.getStaffEmail()+"', '"+staffaccount.getStaffPassword()+"');";;
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error occurred at ConSql->createAccount()");
            return false;
        }

    }

}