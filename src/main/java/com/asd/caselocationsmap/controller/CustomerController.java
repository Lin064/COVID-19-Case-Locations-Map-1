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
public class CustomerController {
    @RequestMapping(value ="/createCustomer", method = RequestMethod.POST)
    public boolean createCustomer(@RequestBody CustomerAccount ca, HttpServletResponse resp) throws Exception{
        //Use LocalDate to clear the hour, minute, and second data in caseDate
        CreateCustomerAccountSql casql = new CreateCustomerAccountSql();
        boolean flag = casql.createCustomerAccount(ca);
        return flag;
    }

    @RequestMapping(value="/readAccount", method = RequestMethod.POST)
    public CustomerAccount readAccount(@RequestBody CustomerAccount ca, HttpServletResponse resp) throws Exception {
        ReadCustomerAccountSql readCustomerAccountSql = new ReadCustomerAccountSql();
        CustomerAccount cas = readCustomerAccountSql.customerAccount(ca.getEmail());
        return cas;
    }

    @RequestMapping(value="/updateAccount", method = RequestMethod.POST)
    public CustomerAccount updateCustomerAccount(@RequestBody CustomerAccount ca, HttpServletResponse resp) throws Exception{
        UpdateCustomerAccountSql updateCustomerAccountSql = new UpdateCustomerAccountSql();
        updateCustomerAccountSql.updateCustomerAccount(ca);
        return ca;
    }

    @RequestMapping(value ="/verifyCustomer", method = RequestMethod.POST)
        public boolean verifyCustomer(@RequestBody CustomerAccount ca, HttpServletResponse resp, ServletRequest request) throws Exception {
         ReadCustomerAccountSql rca = new ReadCustomerAccountSql();
         boolean flag = rca.verifyAccount(ca);
         HttpServletRequest req = (HttpServletRequest) request;
         HttpSession session = req.getSession();
         if(flag){
             session.setAttribute("isCustomer",true);
             session.setAttribute("email",ca.getEmail());
         } else {
             session.setAttribute("isCustomer", false);
             session.setAttribute("email", "");
         }
         return flag;
    }


}
