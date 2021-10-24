package com.asd.caselocationsmap.controller;
import com.asd.caselocationsmap.dao.*;
import com.asd.caselocationsmap.entity.DailyRecord;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
@RestController
public class DailyRecordController {
    @RequestMapping(value = "/postDailyRecord", method = RequestMethod.POST)
    public DailyRecord postRecord(@RequestBody DailyRecord dr, HttpServletResponse resp) throws Exception {
        CreateDailyRecordSql drSql = new CreateDailyRecordSql();
        DailyRecord dr2 = drSql.createDailyRecord(dr);
       return dr2;
    }

    @RequestMapping(value = "/getDailyRecordByDate", method = RequestMethod.POST)
    public DailyRecord getRecordByDate(@RequestBody DailyRecord d, HttpServletResponse resp){
        ReadDailyRecordSql drSql = new ReadDailyRecordSql();
        DailyRecord dr = drSql.getDailyRecordbyDate(d.getPublishDate());
        return dr;
    }

    @RequestMapping(value = "/getLatestDailyRecord", method = RequestMethod.POST)
    public DailyRecord getLatestRecord(HttpServletResponse resp){
        ReadDailyRecordSql drSql = new ReadDailyRecordSql();
        DailyRecord dr = drSql.getLatestDailyRecord();
        return dr;
    }

    @RequestMapping(value = "/getDailyRecordById", method = RequestMethod.POST)
    public DailyRecord getRecordById(@RequestBody int id, HttpServletResponse resp){
        ReadDailyRecordSql drSql = new ReadDailyRecordSql();
        DailyRecord dr = drSql.getDailyRecordbyId(id);
        return dr;
    }

    @RequestMapping(value = "/getDailyRecord", method = RequestMethod.POST)
    public ArrayList<DailyRecord> getRecord(HttpServletResponse resp){
        ReadDailyRecordSql drSql = new ReadDailyRecordSql();
        ArrayList<DailyRecord> drs = drSql.getDailyRecord();
        return drs;
    }

    @RequestMapping(value = "/updateDailyRecord", method = RequestMethod.POST)
    public DailyRecord updateDailyRecord(@RequestBody DailyRecord dr, HttpServletResponse resp){
        UpdateDailyRecordSql urs = new UpdateDailyRecordSql();
        urs.updateDailyRecord(dr);
        return dr;
    }

    @RequestMapping(value = "/deleteDailyRecord", method = RequestMethod.POST)
    public DailyRecord deleteDailyRecord(@RequestBody DailyRecord dr, HttpServletResponse resp){
        DeleteDailyRecordSql ddrs = new DeleteDailyRecordSql();
        ddrs.removeDailyRecord(dr);
        return dr;
    }




}