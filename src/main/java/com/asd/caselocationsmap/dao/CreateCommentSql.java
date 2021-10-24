package com.asd.caselocationsmap.dao;

import com.asd.caselocationsmap.entity.Comment;

import java.sql.*;

public class CreateCommentSql
{
    public void createComment(Comment comment)
    {

        try{
            String username = "asd";
            String password = "Mypassword1@";
            String connectionUrl = "jdbc:mysql://103.149.46.76:3306/demodb";

            Connection conn = DriverManager.getConnection(connectionUrl, username, password);

            String sql = "insert into COVID19_comment (comment_id, comment_author, comment_author_type, comment_date, comment_context, comment_status, comment_topic_id) values (DEFAULT "+", '"+comment.getAuthor()+"', '"+comment.getAuthorType()+"', '"+comment.getDate()+"', '"+comment.getContext()+"', "+comment.getStatus()+", "+comment.getTopicId()+");";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn.close();
            System.out.println("[Hint] Create " + comment.getContext() + " into Database Successful!");
        } catch (SQLException e) {
            System.out.println("[Hint] Error occurred at ConSql->createComment()\n" + e);
        }
    }
}
