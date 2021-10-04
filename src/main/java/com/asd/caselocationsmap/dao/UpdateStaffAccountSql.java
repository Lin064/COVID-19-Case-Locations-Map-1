package com.asd.caselocationsmap.dao;
import com.asd.caselocationsmap.entity.StaffAccount;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateStaffAccountSql {

    public void updateAccount(StaffAccount sa) {
        try {
            String username = "asd";
            String password = "Mypassword1@";
            String connectionUrl = "jdbc:mysql://103.149.46.76:3306/demodb";
            Connection conn = DriverManager.getConnection(connectionUrl, username, password);
            String sql = "update StaffAccount set staffemail = '"+sa.getStaffEmail()+"', staffpassword = '"+sa.getStaffPassword()+"' where staffid = '"+sa.getStaffId()+"'";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error at update");
        }
    }

}
