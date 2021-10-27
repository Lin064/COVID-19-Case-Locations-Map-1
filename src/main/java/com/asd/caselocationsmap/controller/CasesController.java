package com.asd.caselocationsmap.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.asd.caselocationsmap.dao.CreateCasesSql;
import com.asd.caselocationsmap.dao.DeleteCasesSql;
import com.asd.caselocationsmap.dao.ReadCasesSql;
import com.asd.caselocationsmap.dao.UpdateCasesSql;
import com.asd.caselocationsmap.entity.Cases;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@RestController
public class CasesController {
    @RequestMapping(value ="/cases", method = RequestMethod.GET)
    public void getCases(HttpServletResponse resp) throws Exception{
        ReadCasesSql readCasesSql = new ReadCasesSql();
        List<Cases> cases = readCasesSql.select_all();
        JSONArray JSONObj = (JSONArray) JSON.toJSON(cases);
        String JsonStr = JSON.toJSONString(JSONObj, SerializerFeature.PrettyFormat);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.getWriter().write(JsonStr);
    }

    @RequestMapping(value ="/cases", method = RequestMethod.POST)
    public Cases postCases(@RequestBody Cases casesDetails, HttpServletResponse resp) throws Exception{
        //Use LocalDate to clear the hour, minute, and second data in caseDate
        LocalDate caseDate=casesDetails.getCaseDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Date newCaseDate=java.sql.Date.valueOf(caseDate);
        casesDetails.setCaseDate(newCaseDate);

        //Use LocalDate to clear the hour, minute, and second data in LastUpdatedDate
        LocalDate lastUpdated=casesDetails.getLastUpdated().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Date newLastUpdated=java.sql.Date.valueOf(lastUpdated);
        casesDetails.setLastUpdated(newLastUpdated);

        CreateCasesSql createCasesSql = new CreateCasesSql();
        createCasesSql.createCases(casesDetails);
        return casesDetails;
    }

    @RequestMapping(value ="/cases", method = RequestMethod.PUT)
    public Cases putNews(@RequestBody Cases casesDetails, HttpServletResponse resp) throws Exception{
        //Use LocalDate to clear the hour, minute, and second data in caseDate
        LocalDate caseDate=casesDetails.getCaseDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Date newCaseDate=java.sql.Date.valueOf(caseDate);
        casesDetails.setCaseDate(newCaseDate);

        //Use LocalDate to clear the hour, minute, and second data in LastUpdatedDate
        LocalDate lastUpdated=casesDetails.getLastUpdated().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Date newLastUpdated=java.sql.Date.valueOf(lastUpdated);
        casesDetails.setLastUpdated(newLastUpdated);

        UpdateCasesSql updateCasesSql = new UpdateCasesSql();
        updateCasesSql.updateCases(casesDetails);
        return casesDetails;
    }

    @RequestMapping(value ="/cases", method = RequestMethod.DELETE)
    public void deleteNews(@RequestBody Cases casesDetails, HttpServletResponse resp) throws Exception{
        DeleteCasesSql deleteCasesSql = new DeleteCasesSql();
        deleteCasesSql.removeCases(casesDetails.getId());
    }
}
