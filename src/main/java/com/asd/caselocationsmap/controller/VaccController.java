package com.asd.caselocationsmap.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.asd.caselocationsmap.dao.*;
import com.asd.caselocationsmap.entity.vaccInjectLocation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class VaccController {
    @RequestMapping(value = "/VaccInjectLocation1", method = RequestMethod.GET)
    public void getVaccInjectLocation(HttpServletResponse resp) throws Exception {
        ReadVaccInjectLocationSql readVaccInjectLocationSql = new ReadVaccInjectLocationSql();
        List<vaccInjectLocation> tbs = readVaccInjectLocationSql.select_all();
        JSONArray JSONObj = (JSONArray) JSON.toJSON(tbs);
        String JsonStr = JSON.toJSONString(JSONObj, SerializerFeature.PrettyFormat);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.getWriter().write(JsonStr);
    }

    @RequestMapping(value = "/VaccInjectLocation2", method = RequestMethod.POST)
    public vaccInjectLocation postVaccInjectLocation(@RequestBody vaccInjectLocation tb, HttpServletResponse resp) throws Exception {

        CreateVaccInjectLocationSQL createVaccInjectLocationSQL = new CreateVaccInjectLocationSQL();
        createVaccInjectLocationSQL.createVaccInjectLocation(tb);
        return tb;
    }

    @RequestMapping(value ="/VaccInjectLocation3", method = RequestMethod.PUT)
    public vaccInjectLocation putVaccInjectLocation(@RequestBody vaccInjectLocation tb, HttpServletResponse resp) throws Exception{
        UpdateVaccInjectLocationSql updateVaccInjectLocationSql = new UpdateVaccInjectLocationSql();
        updateVaccInjectLocationSql.updatevaccInjectLocation(tb);
        return tb;
    }

    @RequestMapping(value ="/VaccInjectLocation4", method = RequestMethod.DELETE)
    public void deleteVaccInjectLocation(@RequestBody vaccInjectLocation tb, HttpServletResponse resp) throws Exception{
        DeleteVaccInjectLocationSql deleteVaccInjectLocationSql = new DeleteVaccInjectLocationSql();
        deleteVaccInjectLocationSql.removevaccInjectLocationSql(tb.getId());
    }

}

