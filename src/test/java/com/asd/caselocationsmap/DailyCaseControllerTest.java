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
@WebMvcTest(DailyRecordController.class)
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

    @Order(1)
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

    @Order(2)
    @Test
    @DisplayName("Test read case record")
    void readCaseRecord() throws Exception {
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/getDailyRecord")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        String result = mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Order(3)
    @Test
    @DisplayName("Test read case record")
    void readCaseRecordbyDate() throws Exception {
        String content = "{\"publishDate\":\"2000-10-01\"}";
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/getDailyRecordByDate")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
    }

    @Order(4)
    @Test
    @DisplayName("Test Update case record")
    void updateCaseRecord() throws Exception {
        String content = "{\"newCase\":100,\"deaths\":100,\"curedCase\":100,\"severe_case\":100,\"total_case\":1000,\"publishDate\":\"2000-10-01\"}";
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/updateDailyRecordbyEmail")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);
        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.newCase").value(100))
                .andExpect(jsonPath("$.deaths").value(100))
                .andExpect(jsonPath("$.curedCase").value(100))
                .andExpect(jsonPath("$.severe_case").value(100))
                .andExpect(jsonPath("$.total_case").value(1000))
                .andExpect(jsonPath("$.publishDate").value("2000-10-01"));
    }

    @Order(5)
    @Test
    @DisplayName("Test Delete case record")
    void deleteCaseRecord() throws Exception {
        String content = "{\"publishDate\":\"2000-10-01\"}";
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/deleteDailyRecordbyEmail")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);
        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
    }
}