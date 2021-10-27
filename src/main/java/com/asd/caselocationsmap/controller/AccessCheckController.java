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
    public void verifyUserLogin(HttpServletResponse resp, ServletRequest request) throws Exception {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        String email = "";
        if(session.getAttribute("isCustomer")!=null){
            boolean flag = (boolean)session.getAttribute("isCustomer");
            if(flag){
                email = (String)session.getAttribute("email");
            }
        }
        String JsonStr = JSON.toJSONString(email, SerializerFeature.PrettyFormat);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.getWriter().write(JsonStr);
    }

    @RequestMapping(value ="/checkManagerLogin", method = RequestMethod.POST)
    public void verifyManagerLogin(HttpServletResponse resp, ServletRequest request) throws Exception {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        String email = "";
        if(session.getAttribute("isStaff")!=null){
            boolean flag = (boolean)session.getAttribute("isStaff");
            if(flag){
                email = (String)session.getAttribute("email");
            }
        }
        String JsonStr = JSON.toJSONString(email, SerializerFeature.PrettyFormat);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.getWriter().write(JsonStr);
    }

    @RequestMapping(value ="/toLogout", method = RequestMethod.POST)
    public void logout(HttpServletResponse resp, ServletRequest request) throws Exception {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        session.invalidate();
        String JsonStr = JSON.toJSONString("logout", SerializerFeature.PrettyFormat);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.getWriter().write(JsonStr);
    }




}