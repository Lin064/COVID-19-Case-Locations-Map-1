package com.asd.caselocationsmap.dao;


import com.asd.caselocationsmap.entity.CustomerAccount;
import java.sql.*;
public class CreateCustomerAccountSql {
    public boolean checkEmailExistence(String email){
        try{
            String username = "asd";
            String password = "ASDpassword";
            String connectionUrl = "jdbc:mysql://aa1k7pic2tpxd6q.cn9vqfnivxwa.us-east-2.rds.amazonaws.com/CovidMap";
            Connection conn = DriverManager.getConnection(connectionUrl, username, password);

            String sql = "Select * from Register where email='"+email+"'";
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



    public boolean createCustomerAccount(CustomerAccount ca) {
        try{
            String username = "asd";
            String password = "Mypassword1@";
            String connectionUrl = "jdbc:mysql://103.149.46.76:3306/demodb";
            Connection conn = DriverManager.getConnection(connectionUrl, username, password);
            if(!checkEmailExistence(ca.getEmail())){
                conn.close();
                return false;
            }
            String sql = "insert into Register(email,name,phone,password) Values('"+ca.getEmail()+"','" +ca.getName()+"','"+ca.getPhone()+"','"+ca.getPassword()+"'" +")";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error occurred at ConSql->createCutomerAccount()");
            return false;
        }
    }
}
