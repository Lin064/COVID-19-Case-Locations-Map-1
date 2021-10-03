package com.asd.caselocationsmap.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.asd.caselocationsmap.dao.CreateStaffAccountSql;

import com.asd.caselocationsmap.dao.DeleteStaffAccountSql;
import com.asd.caselocationsmap.dao.ReadStaffAccountSql;
import com.asd.caselocationsmap.dao.UpdateStaffAccountSql;
import com.asd.caselocationsmap.entity.StaffAccount;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class StaffAccountController {
    @RequestMapping(value="/staffAccount", method = RequestMethod.POST)
    public StaffAccount postStaffAccount(@RequestBody StaffAccount sa, HttpServletResponse resp) throws Exception{
        CreateStaffAccountSql createStaffAccountSql = new CreateStaffAccountSql();
        createStaffAccountSql.createStaffAccount(sa);
        return sa;
    }

    @RequestMapping(value="/readAccounts", method = RequestMethod.POST)
    public void readAccounts(HttpServletResponse resp) throws Exception{
        ReadStaffAccountSql readStaffAccountSql = new ReadStaffAccountSql();
        List<StaffAccount> sas = readStaffAccountSql.select_all();
        JSONArray JSONObj = (JSONArray) JSON.toJSON(sas);
        String JsonStr = JSON.toJSONString(JSONObj, SerializerFeature.PrettyFormat);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.getWriter().write(JsonStr);
    }

    @RequestMapping(value ="/deleteAccount", method = RequestMethod.POST)
    public void deleteAccount(@RequestBody String id, HttpServletResponse resp) throws Exception {
        DeleteStaffAccountSql deleteStaffAccountSql = new DeleteStaffAccountSql();
        deleteStaffAccountSql.deleteAccount(Integer.parseInt(id));
        String JsonStr = JSON.toJSONString(id, SerializerFeature.PrettyFormat);
        resp.getWriter().write(JsonStr);
        System.out.println("controller");
    }

    @RequestMapping(value="/updates", method = RequestMethod.POST)
    public StaffAccount updateStaffAccount(@RequestBody StaffAccount sa, HttpServletResponse resp) throws Exception{
        UpdateStaffAccountSql updateStaffAccountSql = new UpdateStaffAccountSql();
        updateStaffAccountSql.updateAccount(sa);
        return sa;
    }

}
