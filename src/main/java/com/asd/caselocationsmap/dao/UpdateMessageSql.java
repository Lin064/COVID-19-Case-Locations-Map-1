package com.asd.caselocationsmap.dao;

import com.asd.caselocationsmap.entity.Message;

import java.sql.*;

public class UpdateMessageSql
{
    public void updateMessage(Message message)
    {
        try{
            String username = "asd";
            String password = "ASDpassword";
            String connectionUrl = "jdbc:mysql://aa1k7pic2tpxd6q.cn9vqfnivxwa.us-east-2.rds.amazonaws.com/CovidMap";

            Connection conn = DriverManager.getConnection(connectionUrl, username, password);
            String sql = "";
            int id = message.getId();
            if(id == 0)
            {
                sql = "update COVID19_Message set topic_title = '"+message.getTitle()+"', topic_date = '"+message.getDate()+"',topic_type = '"+message.getType()+"',topic_author = '"+message.getAuthor()+"',topic_author_type = '"+message.getAuthorType()+"',topic_tag= '"+message.getTag()+"',topic_context= '"+message.getContext()+"',topic_status = "+message.getStatus()+" WHERE 1 ORDER BY topic_id DESC LIMIT 1";
            }
            else
            {
                sql = "update COVID19_Message set topic_title = '"+message.getTitle()+"', topic_date = '"+message.getDate()+"',topic_type = '"+message.getType()+"',topic_author = '"+message.getAuthor()+"',topic_author_type = '"+message.getAuthorType()+"',topic_tag= '"+message.getTag()+"',topic_context= '"+message.getContext()+"',topic_status = "+message.getStatus()+" where topic_id = '"+message.getId()+"'";
            }

            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn.close();
            System.out.println("[Hint] Update Record Successful!");
        } catch (SQLException e) {
            System.out.println("[Hint} Error occurred at updateMessage()" + e);
        }
    }
}
