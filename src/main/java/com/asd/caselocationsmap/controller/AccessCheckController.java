package com.asd.caselocationsmap.controller;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.asd.caselocationsmap.dao.*;
import com.asd.caselocationsmap.entity.CustomerAccount;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;
@RestController
public class AccessCheckController {

    @RequestMapping(value ="/checkUserLogin", method = RequestMethod.POST)
    public String verifyUserLogin(HttpServletResponse resp, ServletRequest request) throws Exception {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        boolean isCustomer = (boolean)session.getAttribute("isCustomer");
        if(isCustomer){
            return (String)session.getAttribute("email");
        }
        return "";
    }

    @RequestMapping(value ="/checkManagerLogin", method = RequestMethod.POST)
    public String verifyManagerLogin(HttpServletResponse resp, ServletRequest request) throws Exception {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        boolean isStaff = (boolean)session.getAttribute("isStaff");
        if(isStaff){
            return (String)session.getAttribute("email");
        }
        return "";
    }




}