package com.asd.caselocationsmap.dao;

import com.asd.caselocationsmap.entity.Comment;

import java.sql.*;
import java.util.ArrayList;

public class ReadCommentSql
{
    public ArrayList<Comment> readAllComment()
    {
        try {
            String username = "asd";
            String password = "ASDpassword";
            String connectionUrl = "jdbc:mysql://aa1k7pic2tpxd6q.cn9vqfnivxwa.us-east-2.rds.amazonaws.com/CovidMap";

            Connection conn = DriverManager.getConnection(connectionUrl, username, password);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM COVID19_comment;");
            ArrayList<Comment> array = new ArrayList<Comment>();

            while (rs.next()) {
                Comment comment = new Comment();
                comment.setId(rs.getInt("comment_id"));
                comment.setAuthor(rs.getString("comment_author"));
                comment.setAuthorType(rs.getString("comment_author_type"));
                comment.setDate(rs.getString("comment_date"));
                comment.setContext(rs.getString("comment_context"));
                comment.setStatus(rs.getBoolean("comment_status"));
                comment.setTopicId(rs.getInt("comment_topic_id"));
                array.add(comment);
            }
            stmt.close();
            rs.close();
            conn.close();
            System.out.println("[Hint] Get All Records From Database Successful!");
            return array;
        } catch (SQLException e) {
            System.out.println("[Hint] Error occurred at ReadCasesSql->readAllComment()\n" + e);
            return new ArrayList<Comment>();
        }
    }

    public ArrayList<Comment> readComment(int id)
    {
        try {
            String username = "asd";
            String password = "Mypassword1@";
            String connectionUrl = "jdbc:mysql://103.149.46.76:3306/demodb";

            Connection conn = DriverManager.getConnection(connectionUrl, username, password);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM COVID19_comment where comment_id = " + id + ";");
            ArrayList<Comment> array = new ArrayList<Comment>();

            while (rs.next()) {
                Comment comment = new Comment();
                comment.setId(rs.getInt("comment_id"));
                comment.setAuthor(rs.getString("comment_author"));
                comment.setAuthorType(rs.getString("comment_author_type"));
                comment.setDate(rs.getString("comment_date"));
                comment.setContext(rs.getString("comment_context"));
                comment.setStatus(rs.getBoolean("comment_status"));
                comment.setTopicId(rs.getInt("comment_topic_id"));
                array.add(comment);
            }
            stmt.close();
            rs.close();
            conn.close();
            System.out.println("[Hint] Get Record From Database Successful!");
            return array;
        } catch (SQLException e) {
            System.out.println("[Hint] Error occurred at ReadCasesSql->readComment()\n" + e);
            return new ArrayList<Comment>();
        }
    }
}
