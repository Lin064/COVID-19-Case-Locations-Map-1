package com.asd.caselocationsmap;

import com.alibaba.fastjson.JSONObject;
import com.asd.caselocationsmap.controller.BookingController;
import com.asd.caselocationsmap.controller.CasesController;
import com.asd.caselocationsmap.entity.TestBooking;
import org.apache.coyote.Response;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import java.util.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@WebMvcTest(BookingController.class)
public class TestBookingControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    BookingController bookingController;

    @BeforeEach
    void initEach(){
        mockMvc = MockMvcBuilders.standaloneSetup(bookingController).build();
        System.out.println("BeforeEach init succeed!");
    }

    @Order (1)
    @Test
    @DisplayName("test create booking")
    void createBooking() throws Exception {
        String content = "{\"fname\":\"Allen\",\"lname\":\"Ai\",\"strnum\":\"06\",\"str\":\"royal\",\"suburb\":\"Auburn\",\"email\":\"1179903915@qq.com\",\"phone\":\"18759111420\",\"date\":\"2021-10-06\",\"status\":\"Continue\",\"result\":\"No Published\"}";
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/testBooking")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.lname").value("Ai"))
                .andExpect(jsonPath("$.fname").value("Allen"))
                .andExpect(jsonPath("$.strnum").value("06"))
                .andExpect(jsonPath("$.str").value("royal"))
                .andExpect(jsonPath("$.suburb").value("Auburn"))
                .andExpect(jsonPath("$.email").value("1179903915@qq.com"))
                .andExpect(jsonPath("$.phone").value("18759111420"))
                .andExpect(jsonPath("$.date").value("2021-10-06"))
                .andExpect(jsonPath("$.status").value("Continue"))
                .andExpect(jsonPath("$.result").value("No Published"));
    }

    @Order (2)
    @Test
    @DisplayName("test read bookings")
    void readBookings() throws Exception {
      MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/testBooking1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
      String result =  mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
      System.out.println(result);
    }

    int getID() throws Exception {
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/testBooking1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        String result =  mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        JSONArray json = JSONArray.parseArray(result);
        // if(json.size()==0) return 0;
        JSONObject ob = json.getJSONObject(json.size()-1);
        int id =ob.getIntValue("id");
        return  id;
    }

    @Order (3)
    @Test
    @DisplayName("test read bookings by suburb")
    void readBookingsByEmail() throws Exception {
        String content = "\"Auburn\"";
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/findBookingbyEmail")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);
        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
    }

    @Order (4)
    @Test
    @DisplayName("test update booking")
    void updateCase() throws Exception {
        int id = getID();
        String content = "{\"id\":"+id+",\"fname\":\"UpdateTest\",\"lname\":\"UpdateTest\",\"strnum\":\"06\",\"str\":\"royal\",\"suburb\":\"Auburn\",\"email\":\"1179903915@qq.com\",\"phone\":\"18759111420\",\"date\":\"2021-10-06\",\"status\":\"Continue\",\"result\":\"No Published\"}";

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/updateBooking")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fname").value("UpdateTest"))
                .andExpect(jsonPath("$.lname").value("UpdateTest"));
    }

    @Order (5)
    @Test
    @DisplayName("test delete booking")
    void deleteBooking() throws Exception {
        int id = getID();
        String content = String.valueOf(id);
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/removeBooking")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);
        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
    }
}
