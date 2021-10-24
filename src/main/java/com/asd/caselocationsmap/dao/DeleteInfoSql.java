package com.asd.caselocationsmap.dao;

import java.sql.*;

public class DeleteInfoSql
{
    public void deleteInfo(int id)
    {
        try{
            String username = "asd";
            String password = "ASDpassword";
            String connectionUrl = "jdbc:mysql://aa1k7pic2tpxd6q.cn9vqfnivxwa.us-east-2.rds.amazonaws.com/CovidMap";

            Connection conn = DriverManager.getConnection(connectionUrl, username, password);
            String sql = "";
            if(id == 0)
            {
                sql = "delete from COVID19_Info order by info_id desc limit 1";
            }
            else
            {
                sql = "delete from COVID19_Info where info_id = '"+id+"'";
            }
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn.close();
            System.out.println("[Hint] Delete Successful!");

        } catch (SQLException e) {
            System.out.println("Error occurred at deleteCases()" + e);
        }
    }
}
