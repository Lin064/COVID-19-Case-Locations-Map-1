package com.asd.caselocationsmap.dao;

import com.asd.caselocationsmap.entity.Message;

import java.sql.*;

public class CreateMessageSql
{
    public void createMessage(Message message)
    {

        try{
            String username = "asd";
            String password = "ASDpassword";
            String connectionUrl = "jdbc:mysql://aa1k7pic2tpxd6q.cn9vqfnivxwa.us-east-2.rds.amazonaws.com/CovidMap";

            Connection conn = DriverManager.getConnection(connectionUrl, username, password);

            System.out.println(message.getTitle());
            String sql = "insert into COVID19_Message (topic_id, topic_title, topic_date, topic_type, topic_author, topic_author_type, topic_tag, topic_context, topic_status) values (DEFAULT "+", '"+message.getTitle()+"', '"+message.getDate()+"', '"+message.getType()+"', '"+message.getAuthor()+"', '"+message.getAuthorType()+"', '"+message.getTag()+"', '"+message.getContext()+"', "+message.getStatus()+");";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn.close();
            System.out.println("[Hint] Create " + message.getTitle() + " into Database Successful!");
        } catch (SQLException e) {
            System.out.println("[Hint] Error occurred at ConSql->createMessage()\n" + e);
        }
    }
}
