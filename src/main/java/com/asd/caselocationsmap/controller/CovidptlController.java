package com.asd.caselocationsmap.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.asd.caselocationsmap.dao.*;
import com.asd.caselocationsmap.entity.covidPtl;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class CovidptlController {
    @RequestMapping(value = "/Covid19_PublicTestLocation1", method = RequestMethod.GET)
    public void getCovidPtl(HttpServletResponse resp) throws Exception {
        ReadCovidptlSql readCovidptlSql = new ReadCovidptlSql();
        List<covidPtl> tbs = readCovidptlSql.select_all();
        JSONArray JSONObj = (JSONArray) JSON.toJSON(tbs);
        String JsonStr = JSON.toJSONString(JSONObj, SerializerFeature.PrettyFormat);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.getWriter().write(JsonStr);
    }

    @RequestMapping(value = "/Covid19_PublicTestLocation2", method = RequestMethod.POST)
    public covidPtl postCovidPtl(@RequestBody covidPtl tb, HttpServletResponse resp) throws Exception {

        CreateCovidptlSQL createCovidptlSQL = new CreateCovidptlSQL();
        createCovidptlSQL.createcovidPtl(tb);
        return tb;
    }

    @RequestMapping(value ="/Covid19_PublicTestLocation3", method = RequestMethod.PUT)
    public covidPtl putCovidPtl(@RequestBody covidPtl tb, HttpServletResponse resp) throws Exception{
        UpdateCovidptlSql updateCovidptlSql = new UpdateCovidptlSql();
        updateCovidptlSql.updatecovidPtl(tb);
        return tb;
    }

    @RequestMapping(value ="/Covid19_PublicTestLocation4", method = RequestMethod.DELETE)
    public void deleteCovidptl(@RequestBody covidPtl tb, HttpServletResponse resp) throws Exception{
        DeleteCovidptlSql deleteCovidptlSql = new DeleteCovidptlSql();
        deleteCovidptlSql.removecovidPtlSql(tb.getId());
    }

}

