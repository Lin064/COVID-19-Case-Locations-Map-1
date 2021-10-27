package com.asd.caselocationsmap.dao;

import com.asd.caselocationsmap.entity.Info;

import java.sql.*;

public class UpdateInfoSql
{
    public void updateInfo(Info info)
    {
        try{
            String username = "asd";
            String password = "Mypassword1@";
            String connectionUrl = "jdbc:mysql://103.149.46.76:3306/demodb";

            Connection conn = DriverManager.getConnection(connectionUrl, username, password);
            String sql = "";
            int id = info.getId();
            if(id == 0)
            {
                sql = "update COVID19_Info set info_title = '"+info.getTitle()+"', info_date = '"+info.getDate()+"',info_type = '"+info.getType()+"',info_author = '"+info.getAuthor()+"',info_description= '"+info.getDescription()+"',info_context= '"+info.getContext()+"',info_status = "+info.getStatus()+" WHERE 1 ORDER BY info_id DESC LIMIT 1";
            }
            else
            {
                sql = "update COVID19_Info set info_title = '"+info.getTitle()+"', info_date = '"+info.getDate()+"',info_type = '"+info.getType()+"',info_author = '"+info.getAuthor()+"',info_description= '"+info.getDescription()+"',info_context= '"+info.getContext()+"',info_status = "+info.getStatus()+" where info_id = '"+info.getId()+"'";
            }

            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn.close();
            System.out.println("[Hint] Update Record Successful!");
        } catch (SQLException e) {
            System.out.println("[Hint} Error occurred at updateInfo()" + e);
        }
    }
}
