package com.asd.caselocationsmap.dao;

import com.asd.caselocationsmap.entity.Info;

import java.sql.*;

public class CreateInfoSql
{
    public void createInfo(Info info)
    {

        try{
            String username = "asd";
            String password = "ASDpassword";
            String connectionUrl = "jdbc:mysql://aa1k7pic2tpxd6q.cn9vqfnivxwa.us-east-2.rds.amazonaws.com:3306/CovidMap";

            Connection conn = DriverManager.getConnection(connectionUrl, username, password);

            System.out.println(info.getTitle());
            String sql = "insert into COVID19_Info (info_id, info_title, info_date, info_type, info_author, info_description, info_context, info_status) values (DEFAULT "+", '"+info.getTitle()+"', '"+info.getDate()+"', '"+info.getType()+"', '"+info.getAuthor()+"', '"+info.getDescription()+"', '"+info.getContext()+"', "+info.getStatus()+");";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn.close();
            System.out.println("[Hint] Create " + info.getTitle() + " into Database Successful!");
        } catch (SQLException e) {
            System.out.println("[Hint] Error occurred at ConSql->createInfo()\n" + e);
        }
    }
}
