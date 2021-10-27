package com.asd.caselocationsmap.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.asd.caselocationsmap.dao.CreateCommentSql;
import com.asd.caselocationsmap.dao.DeleteCommentSql;
import com.asd.caselocationsmap.dao.ReadCommentSql;
import com.asd.caselocationsmap.dao.UpdateCommentSql;
import com.asd.caselocationsmap.entity.Comment;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CommentController
{
    @RequestMapping(value ="/comment1", method = RequestMethod.POST)
    public void getComment(HttpServletResponse resp) throws Exception
    {
        ReadCommentSql readCommentSql = new ReadCommentSql();
        List<Comment> comment = readCommentSql.readAllComment();
        JSONArray JSONObj = (JSONArray) JSON.toJSON(comment);
        String JsonStr = JSON.toJSONString(JSONObj, SerializerFeature.PrettyFormat);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.getWriter().write(JsonStr);
    }

    @RequestMapping(value ="/comment2", method = RequestMethod.POST)
    public Comment postComment(@RequestBody Comment commentDetails, HttpServletResponse resp) throws Exception
    {
        System.out.println("debug");
        CreateCommentSql createCommentSql = new CreateCommentSql();
        createCommentSql.createComment(commentDetails);
        return commentDetails;
    }

    @RequestMapping(value ="/comment3", method = RequestMethod.POST)
    public Comment putComment(@RequestBody Comment commentDetails, HttpServletResponse resp) throws Exception
    {

        UpdateCommentSql updateCommentSql = new UpdateCommentSql();
        updateCommentSql.updateComment(commentDetails);
        return commentDetails;
    }

    @RequestMapping(value ="/comment4", method = RequestMethod.POST)
    public void deleteComment(@RequestBody String id, HttpServletResponse resp) throws Exception
    {
        DeleteCommentSql deleteCommentSql = new DeleteCommentSql();
        deleteCommentSql.deleteComment(Integer.parseInt(id));
        String JsonStr = JSON.toJSONString(id, SerializerFeature.PrettyFormat);
        resp.getWriter().write(JsonStr);
    }

    @RequestMapping(value ="/comment5", method = RequestMethod.POST)
    public void getSingleComment(@RequestBody String id, HttpServletResponse resp) throws Exception
    {
        ReadCommentSql readCommentSql = new ReadCommentSql();
        List<Comment> comment = readCommentSql.readComment(Integer.parseInt(id));
        JSONArray JSONObj = (JSONArray) JSON.toJSON(comment);
        String JsonStr = JSON.toJSONString(JSONObj, SerializerFeature.PrettyFormat);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.getWriter().write(JsonStr);
    }

}
