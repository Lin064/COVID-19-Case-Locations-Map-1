//package com.asd.caselocationsmap;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.asd.caselocationsmap.controller.CustomerController;
//import com.asd.caselocationsmap.controller.StaffAccountController;
//import org.junit.jupiter.api.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@WebMvcTest(CustomerController.class)
//public class UserAccountTest {
//    @Autowired
//    MockMvc mockMvc;
//    @Autowired
//    CustomerController customerController;
//
//    @BeforeEach
//    void initEach(){
//        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
//        System.out.println("BeforeEach init succeed!");
//    }
//
////    @Order (1)
////    @Test
////    @DisplayName("Test Read Customer Account")
////    void readAccount() throws Exception {
////        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/readAccount")
////                .contentType(MediaType.APPLICATION_JSON)
////                .accept(MediaType.APPLICATION_JSON);
////
////        mockMvc.perform(mockRequest)
////                .andExpect(status().isOk());
////    }
//
//
//
//}
