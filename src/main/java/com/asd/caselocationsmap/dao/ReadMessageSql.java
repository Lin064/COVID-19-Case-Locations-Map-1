package com.asd.caselocationsmap.dao;

import com.asd.caselocationsmap.entity.Message;

import java.sql.*;
import java.util.ArrayList;

public class ReadMessageSql
{
    public ArrayList<Message> readAllMessage()
    {
        try {
            String username = "asd";
            String password = "ASDpassword";
            String connectionUrl = "jdbc:mysql://aa1k7pic2tpxd6q.cn9vqfnivxwa.us-east-2.rds.amazonaws.com/CovidMap";

            Connection conn = DriverManager.getConnection(connectionUrl, username, password);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM COVID19_Message;");
            ArrayList<Message> array = new ArrayList<Message>();

            while (rs.next()) {
                Message message = new Message();
                message.setId(rs.getInt("topic_id"));
                message.setTitle(rs.getString("topic_title"));
                message.setDate(rs.getString("topic_date"));
                message.setType(rs.getString("topic_type"));
                message.setAuthor(rs.getString("topic_author"));
                message.setAuthorType(rs.getString("topic_author_type"));
                message.setTag(rs.getString("topic_tag"));
                message.setContext(rs.getString("topic_context"));
                message.setStatus(rs.getBoolean("topic_status"));
                array.add(message);
            }
            stmt.close();
            rs.close();
            conn.close();
            System.out.println("[Hint] Get All Records From Database Successful!");
            return array;
        } catch (SQLException e) {
            System.out.println("[Hint] Error occurred at ReadCasesSql->readAllMessage()\n" + e);
            return new ArrayList<Message>();
        }
    }

    public ArrayList<Message> readMessage(int id)
    {
        try {
            String username = "asd";
            String password = "Mypassword1@";
            String connectionUrl = "jdbc:mysql://103.149.46.76:3306/demodb";

            Connection conn = DriverManager.getConnection(connectionUrl, username, password);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM COVID19_Message where topic_id = " + id + ";");
            ArrayList<Message> array = new ArrayList<Message>();

            while (rs.next()) {
                Message message = new Message();
                message.setId(rs.getInt("topic_id"));
                message.setTitle(rs.getString("topic_title"));
                message.setDate(rs.getString("topic_date"));
                message.setType(rs.getString("topic_type"));
                message.setAuthor(rs.getString("topic_author"));
                message.setAuthorType(rs.getString("topic_author_type"));
                message.setTag(rs.getString("topic_tag"));
                message.setContext(rs.getString("topic_context"));
                message.setStatus(rs.getBoolean("topic_status"));
                array.add(message);
            }
            stmt.close();
            rs.close();
            conn.close();
            System.out.println("[Hint] Get Record From Database Successful!");
            return array;
        } catch (SQLException e) {
            System.out.println("[Hint] Error occurred at ReadCasesSql->readMessage()\n" + e);
            return new ArrayList<Message>();
        }
    }
}
