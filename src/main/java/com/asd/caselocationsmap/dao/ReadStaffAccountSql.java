package com.asd.caselocationsmap.dao;
import com.asd.caselocationsmap.entity.CustomerAccount;
import com.asd.caselocationsmap.entity.StaffAccount;
import java.sql.*;
import java.util.ArrayList;

public class ReadStaffAccountSql {

        public ArrayList<StaffAccount> select_all() {
                try{
                        String username = "asd";
                        String password = "ASDpassword";
                        String connectionUrl = "jdbc:mysql://aa1k7pic2tpxd6q.cn9vqfnivxwa.us-east-2.rds.amazonaws.com:3306/CovidMap";
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

        public boolean verifyAccount(StaffAccount sa){
                try {
                        String username = "asd";
                        String password = "ASDpassword";
                        String connectionUrl = "jdbc:mysql://aa1k7pic2tpxd6q.cn9vqfnivxwa.us-east-2.rds.amazonaws.com:3306/CovidMap";
                        Connection conn = DriverManager.getConnection(connectionUrl, username, password);
                        Statement stmt = conn.createStatement();
                        String sql = "SELECT * FROM StaffAccount Where staffemail ='"+sa.getStaffEmail()+"';" ;
                        String   password1 = sa.getStaffPassword();
                        String  dbPwd = "";
                        ResultSet rs = stmt.executeQuery(sql);
                        int i = 0;
                        while (rs.next()) {
                                dbPwd = rs.getString("staffpassword");
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
                        System.out.println("Error occurred at Staff Account->verify()");
                        System.out.println(e);
                        return false;
                }
        }

}
