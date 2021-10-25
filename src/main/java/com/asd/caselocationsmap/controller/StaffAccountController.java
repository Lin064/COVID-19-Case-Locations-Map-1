package com.asd.caselocationsmap.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.asd.caselocationsmap.dao.*;

import com.asd.caselocationsmap.entity.CustomerAccount;
import com.asd.caselocationsmap.entity.StaffAccount;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class StaffAccountController {
    @RequestMapping(value="/staffAccount", method = RequestMethod.POST)
    public boolean postStaffAccount(@RequestBody StaffAccount sa, HttpServletResponse resp) throws Exception{
        CreateStaffAccountSql createStaffAccountSql = new CreateStaffAccountSql();
        boolean flag = createStaffAccountSql.createStaffAccount(sa);
        return flag;
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

    @RequestMapping(value ="/verifyStaff", method = RequestMethod.POST)
    public boolean verifyStaff(@RequestBody StaffAccount sa, HttpServletResponse resp, ServletRequest request) throws Exception {
        ReadStaffAccountSql rsaq = new ReadStaffAccountSql();
        boolean flag = rsaq.verifyAccount(sa);
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        if(flag){
            session.setAttribute("isStaff",true);
            session.setAttribute("email",sa.getStaffEmail());
			session.setAttribute("admin", true);
        } else{
        session.setAttribute("isStaff",false);
        session.setAttribute("email","");}
        return flag;
    }

}
