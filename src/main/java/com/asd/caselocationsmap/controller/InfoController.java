package com.asd.caselocationsmap.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.asd.caselocationsmap.dao.CreateInfoSql;
import com.asd.caselocationsmap.dao.DeleteInfoSql;
import com.asd.caselocationsmap.dao.ReadInfoSql;
import com.asd.caselocationsmap.dao.UpdateInfoSql;
import com.asd.caselocationsmap.entity.Info;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
public class InfoController
{
    @RequestMapping(value ="/info1", method = RequestMethod.POST)
    public void getInfo(HttpServletResponse resp) throws Exception
    {
        ReadInfoSql readInfoSql = new ReadInfoSql();
        List<Info> info = readInfoSql.readAllInfo();
        JSONArray JSONObj = (JSONArray) JSON.toJSON(info);
        String JsonStr = JSON.toJSONString(JSONObj, SerializerFeature.PrettyFormat);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.getWriter().write(JsonStr);
    }

    @RequestMapping(value ="/info2", method = RequestMethod.POST)
    public Info postInfo(@RequestBody Info infoDetails, HttpServletResponse resp) throws Exception
    {
        CreateInfoSql createInfoSql = new CreateInfoSql();
        createInfoSql.createInfo(infoDetails);
        return infoDetails;
    }

    @RequestMapping(value ="/info3", method = RequestMethod.POST)
    public Info putInfo(@RequestBody Info infoDetails, HttpServletResponse resp) throws Exception
    {

        UpdateInfoSql updateInfoSql = new UpdateInfoSql();
        updateInfoSql.updateInfo(infoDetails);
        return infoDetails;
    }

    @RequestMapping(value ="/info4", method = RequestMethod.POST)
    public void deleteInfo(@RequestBody String id, HttpServletResponse resp) throws Exception
    {
        DeleteInfoSql deleteInfoSql = new DeleteInfoSql();
        deleteInfoSql.deleteInfo(Integer.parseInt(id));
        String JsonStr = JSON.toJSONString(id, SerializerFeature.PrettyFormat);
        resp.getWriter().write(JsonStr);
    }

    @RequestMapping(value ="/info5", method = RequestMethod.POST)
    public void getSingleInfo(@RequestBody String id, HttpServletResponse resp) throws Exception
    {
        ReadInfoSql readInfoSql = new ReadInfoSql();
        List<Info> info = readInfoSql.readInfo(Integer.parseInt(id));
        JSONArray JSONObj = (JSONArray) JSON.toJSON(info);
        String JsonStr = JSON.toJSONString(JSONObj, SerializerFeature.PrettyFormat);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.getWriter().write(JsonStr);
    }

}
