package com.asd.caselocationsmap.dao;

import com.asd.caselocationsmap.entity.Comment;

import java.sql.*;

public class UpdateCommentSql
{
    public void updateComment(Comment comment)
    {
        try{
            String username = "asd";
            String password = "ASDpassword";
            String connectionUrl = "jdbc:mysql://aa1k7pic2tpxd6q.cn9vqfnivxwa.us-east-2.rds.amazonaws.com:3306/CovidMap";

            Connection conn = DriverManager.getConnection(connectionUrl, username, password);
            String sql = "";
            int id = comment.getId();
            if(id == 0)
            {
                sql = "update COVID19_comment set comment_author = '"+comment.getAuthor()+"', comment_author_type = '"+comment.getAuthorType()+"',comment_date = '"+comment.getDate()+"',comment_context= '"+comment.getContext()+"',comment_status = "+comment.getStatus()+",comment_topic_id = "+comment.getTopicId()+" WHERE 1 ORDER BY comment_id DESC LIMIT 1";
            }
            else
            {
                sql = "update COVID19_comment set comment_author = '"+comment.getAuthor()+"', comment_author_type = '"+comment.getAuthorType()+"',comment_date = '"+comment.getDate()+"',comment_context= '"+comment.getContext()+"',comment_status = "+comment.getStatus()+",comment_topic_id = "+comment.getTopicId()+" where comment_id = '"+comment.getId()+"'";
            }

            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn.close();
            System.out.println("[Hint] Update Record Successful!");
        } catch (SQLException e) {
            System.out.println("[Hint} Error occurred at updateComment()" + e);
        }
    }
}
