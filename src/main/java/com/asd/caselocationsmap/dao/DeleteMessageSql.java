package com.asd.caselocationsmap.dao;

import java.sql.*;

public class DeleteMessageSql
{
    public void deleteMessage(int id)
    {
        try{
            String username = "asd";
            String password = "ASDpassword";
            String connectionUrl = "jdbc:mysql://aa1k7pic2tpxd6q.cn9vqfnivxwa.us-east-2.rds.amazonaws.com:3306/CovidMap";

            Connection conn = DriverManager.getConnection(connectionUrl, username, password);
            String sql = "";
            if(id == 0)
            {
                sql = "delete from COVID19_Message order by topic_id desc limit 1";
            }
            else
            {
                sql = "delete from COVID19_Message where topic_id = '"+id+"'";
            }
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn.close();
            System.out.println("[Hint] Delete Successful!");

        } catch (SQLException e) {
            System.out.println("Error occurred at deleteMessage()" + e);
        }
    }
}
