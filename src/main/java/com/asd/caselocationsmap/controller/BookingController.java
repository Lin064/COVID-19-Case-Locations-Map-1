package com.asd.caselocationsmap.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.asd.caselocationsmap.dao.*;
import com.asd.caselocationsmap.entity.Cases;
import com.asd.caselocationsmap.entity.TestBooking;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
@RestController
public class BookingController {
    @RequestMapping(value ="/testBooking", method = RequestMethod.POST)
    public TestBooking postbooking(@RequestBody TestBooking tb, HttpServletResponse resp) throws Exception{
        //Use LocalDate to clear the hour, minute, and second data in caseDate
        CreateTestBookingSql createTestBookingSql = new CreateTestBookingSql();
        createTestBookingSql.createTestBooking(tb);
        return tb;
    }

    @RequestMapping(value ="/testBooking1", method = RequestMethod.POST)
    public void getTestBooking(HttpServletResponse resp) throws Exception{
        ReadTestBookingSql readTestBookingSql = new ReadTestBookingSql();
        List<TestBooking> tbs = readTestBookingSql.select_all();
        JSONArray JSONObj = (JSONArray) JSON.toJSON(tbs);
        String JsonStr = JSON.toJSONString(JSONObj, SerializerFeature.PrettyFormat);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.getWriter().write(JsonStr);
    }

    @RequestMapping(value ="/updateBooking", method = RequestMethod.POST)
    public TestBooking updateBooking(@RequestBody TestBooking tb, HttpServletResponse resp) throws Exception{
        //Use LocalDate to clear the hour, minute, and second data in caseDate
        UpdateTestBookingSql updateTestBookingSql = new UpdateTestBookingSql();
        updateTestBookingSql.updateTestBooking(tb);
        return tb;
    }

    @RequestMapping(value ="/findBooking", method = RequestMethod.POST)
    public void getTestBooking(@RequestBody String id, HttpServletResponse resp) throws Exception{
         ReadTestBookingSql readTestBookingSql = new ReadTestBookingSql();
         TestBooking tb = readTestBookingSql.selectById(Integer.parseInt(id));
            String JsonStr = JSON.toJSONString(tb, SerializerFeature.PrettyFormat);
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("application/json");
            resp.getWriter().write(JsonStr);
    }

    @RequestMapping(value ="/findBookingbyEmail", method = RequestMethod.POST)
    public void getTestBookingbyEmail(@RequestBody String email, HttpServletResponse resp) throws Exception{
        ReadTestBookingSql readTestBookingSql = new ReadTestBookingSql();
        List<TestBooking> tbs = readTestBookingSql.selectByEmail(email);
        JSONArray JSONObj = (JSONArray) JSON.toJSON(tbs);
        String JsonStr = JSON.toJSONString(JSONObj, SerializerFeature.PrettyFormat);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.getWriter().write(JsonStr);
    }

    @RequestMapping(value ="/findBookingbySuburb", method = RequestMethod.POST)
    public void getTestBookingbySuburb(@RequestBody String suburb, HttpServletResponse resp) throws Exception{
        ReadTestBookingSql readTestBookingSql = new ReadTestBookingSql();
        List<TestBooking> tbs = readTestBookingSql.selectBySuburb(suburb);
        JSONArray JSONObj = (JSONArray) JSON.toJSON(tbs);
        String JsonStr = JSON.toJSONString(JSONObj, SerializerFeature.PrettyFormat);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.getWriter().write(JsonStr);
    }



    @RequestMapping(value ="/removeBooking", method = RequestMethod.POST)
    public void removeTestBookingbyId(@RequestBody String id, HttpServletResponse resp) throws Exception{
        DeleteTestBookingSql deleteTestBookingSql = new DeleteTestBookingSql();
        deleteTestBookingSql.removeBooking(Integer.parseInt(id));
        String JsonStr = JSON.toJSONString(id, SerializerFeature.PrettyFormat);
        resp.getWriter().write(JsonStr);
    }




}
