package com.asd.caselocationsmap.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.asd.caselocationsmap.dao.CreateMessageSql;
import com.asd.caselocationsmap.dao.DeleteMessageSql;
import com.asd.caselocationsmap.dao.ReadMessageSql;
import com.asd.caselocationsmap.dao.UpdateMessageSql;
import com.asd.caselocationsmap.entity.Message;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MessageController
{
    @RequestMapping(value ="/topic1", method = RequestMethod.POST)
    public void getMessage(HttpServletResponse resp) throws Exception
    {
        ReadMessageSql readMessageSql = new ReadMessageSql();
        List<Message> message = readMessageSql.readAllMessage();
        JSONArray JSONObj = (JSONArray) JSON.toJSON(message);
        String JsonStr = JSON.toJSONString(JSONObj, SerializerFeature.PrettyFormat);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.getWriter().write(JsonStr);
    }

    @RequestMapping(value ="/topic2", method = RequestMethod.POST)
    public Message postMessage(@RequestBody Message messageDetails, HttpServletResponse resp) throws Exception
    {
        CreateMessageSql createMessageSql = new CreateMessageSql();
        createMessageSql.createMessage(messageDetails);
        return messageDetails;
    }

    @RequestMapping(value ="/topic3", method = RequestMethod.POST)
    public Message putMessage(@RequestBody Message messageDetails, HttpServletResponse resp) throws Exception
    {

        UpdateMessageSql updateMessageSql = new UpdateMessageSql();
        updateMessageSql.updateMessage(messageDetails);
        return messageDetails;
    }

    @RequestMapping(value ="/topic4", method = RequestMethod.POST)
    public void deleteMessage(@RequestBody String id, HttpServletResponse resp) throws Exception
    {
        DeleteMessageSql deleteMessageSql = new DeleteMessageSql();
        deleteMessageSql.deleteMessage(Integer.parseInt(id));
        String JsonStr = JSON.toJSONString(id, SerializerFeature.PrettyFormat);
        resp.getWriter().write(JsonStr);
    }

    @RequestMapping(value ="/topic5", method = RequestMethod.POST)
    public void getSingleMessage(@RequestBody String id, HttpServletResponse resp) throws Exception
    {
        ReadMessageSql readMessageSql = new ReadMessageSql();
        List<Message> message = readMessageSql.readMessage(Integer.parseInt(id));
        JSONArray JSONObj = (JSONArray) JSON.toJSON(message);
        String JsonStr = JSON.toJSONString(JSONObj, SerializerFeature.PrettyFormat);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.getWriter().write(JsonStr);
    }

}
