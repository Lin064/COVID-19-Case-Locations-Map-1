package com.asd.caselocationsmap.dao;
import com.asd.caselocationsmap.entity.StaffAccount;
import java.sql.*;
import java.util.ArrayList;

public class ReadStaffAccountSql {

        public ArrayList<StaffAccount> select_all() {
                try{
                        String username = "asd";
                        String password = "Mypassword1@";
                        String connectionUrl = "jdbc:mysql://103.149.46.76:3306/demodb";
                        Connection conn = DriverManager.getConnection(connectionUrl, username, password);

                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM StaffAccount;");
                        ArrayList<StaffAccount> array = new ArrayList<>();

                        while (rs.next()){
                                StaffAccount sa = new StaffAccount();
                                sa.setStaffId(rs.getInt("staffid"));
                                sa.setStaffEmail(rs.getString("staffemail"));
                                sa.setStaffPassword(rs.getString("staffpassword"));
                                array.add(sa);
                        }

                        stmt.close();
                        rs.close();
                        conn.close();
                        System.out.println("success");
                        return array;

                } catch (SQLException e) {
                        System.out.println("Error occurred at ReadStaffAccountSql->select_all()"+e);
                        return new ArrayList<StaffAccount>();
                }
        }

}
