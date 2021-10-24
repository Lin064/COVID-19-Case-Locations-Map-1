package com.asd.caselocationsmap;

import com.alibaba.fastjson.JSONObject;
import com.asd.caselocationsmap.controller.BookingController;

import com.asd.caselocationsmap.controller.DailyRecordController;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.alibaba.fastjson.JSONArray;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@WebMvcTest(BookingController.class)
public class DailyCaseControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    DailyRecordController dailyRecordControllerController;

    @BeforeEach
    void initEach() {
        mockMvc = MockMvcBuilders.standaloneSetup(dailyRecordControllerController).build();
        System.out.println("BeforeEach init succeed!");
    }

    @Order (1)
    @Test
    @DisplayName("Test record Adding")
    void createCaseRecord() throws Exception {
        String content = "{\"newCase\":666,\"deaths\":111,\"curedCase\":37,\"severe_case\":100,\"total_case\":2375,\"publishDate\":\"2000-10-01\"}";

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/postDailyRecord")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.newCase").value(666))
                .andExpect(jsonPath("$.deaths").value(111))
                .andExpect(jsonPath("$.curedCase").value(37))
                .andExpect(jsonPath("$.severe_case").value(100))
                .andExpect(jsonPath("$.total_case").value(2375))
                .andExpect(jsonPath("$.publishDate").value("2000-10-01"));
    }


}