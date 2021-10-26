//package com.asd.caselocationsmap;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
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
//@WebMvcTest(StaffAccountController.class)
//public class AccountManagementTest {
//    @Autowired
//    MockMvc mockMvc;
//    @Autowired
//    StaffAccountController staffAccountController;
//
//    @BeforeEach
//    void initEach(){
//        mockMvc = MockMvcBuilders.standaloneSetup(staffAccountController).build();
//        System.out.println("BeforeEach init succeed!");
//    }
//
//    @Order(1)
//    @Test
//    @DisplayName("Test Create staff account")
//    void createStaffAccount() throws Exception {
//        int id = getID();
//        String content = "{\"staffId\":"+id +",\"staffEmail\": \"test@qq.com\", \"staffPassword\": \"testAdd\"}";
//        System.out.println(content);
//        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/staffAccount")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(content);
//
//       String result =  mockMvc.perform(mockRequest)
//                .andExpect(status().isOk())
//                .andReturn().getResponse().getContentAsString();
//       if(result!=null){
//           boolean flag= Boolean.valueOf(result);
//           if(!flag){
//               deleteAccount();
//               createStaffAccount();
//           }
//       }
//
//        //.andExpect(jsonPath("$.staffId").value(id))
//
//    }
//
//    @Order (2)
//    @Test
//    @DisplayName("Test Read Staff Account")
//    void readAccount() throws Exception {
//        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/readAccounts")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON);
//
//        mockMvc.perform(mockRequest)
//                .andExpect(status().isOk());
//    }
//
//    @Order (3)
//    @Test
//    @DisplayName("Test Update Staff Account")
//    void updateAccount() throws Exception {
//        int id = getID();
//        String content = "{\"staffId\":"+id +",\"staffEmail\": \"test@qq.com\", \"staffPassword\": \"testUpdate\"}";
//        System.out.println(content);
//        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/updates")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(content);
//        mockMvc.perform(mockRequest)
//                .andExpect(status().isOk())
//                //.andExpect(jsonPath("$.staffId").value(id))
//                .andExpect(jsonPath("$.staffEmail").value("test@qq.com"))
//                .andExpect(jsonPath("$.staffPassword").value("testUpdate"));
//    }
//
//
//    @Order (4)
//    @Test
//    @DisplayName("Test Delete Account")
//    void deleteAccount() throws Exception {
//        String content = String.valueOf(getID());
//        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/deleteAccount")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(content);
//        mockMvc.perform(mockRequest)
//                .andExpect(status().isOk());
//    }
//
//    int getID() throws Exception{
//        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/readAccounts")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON);
//        String result = mockMvc.perform(mockRequest)
//                .andExpect(status().isOk())
//                .andReturn().getResponse().getContentAsString();
//
//        JSONArray json = JSONArray.parseArray(result);
//        if(json.size()==0){
//            return 0;
//        }
//        for(int i =0; i<json.size();i++){
//            JSONObject j = json.getJSONObject(i);
//            if(j.getString("staffEmail").equals("test@qq.com")){
//                return j.getIntValue("staffId");
//            }
//        }
//
//        return 0;
//    }
//
//}
