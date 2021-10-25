package com.asd.caselocationsmap;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.asd.caselocationsmap.controller.CustomerController;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@WebMvcTest(CustomerController.class)
public class UserAccountTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    CustomerController customerController;

    @BeforeEach
    void initEach(){
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
        System.out.println("BeforeEach init succeed!");
    }

    @Order(1)
    @Test
    @DisplayName("Test create customer")
    void createCustomer() throws Exception {
        String content = "{\"email\":\"1234@w.com\",\"name\":\"jess\",\"password\":\"1111xxx\",\"phone\":\"12345678\"}";
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/createCustomer1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("1234@w.com"))
                .andExpect(jsonPath("$.name").value("jess"))
                .andExpect(jsonPath("$.password").value("1111xxx"))
                .andExpect(jsonPath("$.phone").value("12345678"));
    }

    @Order (2)
    @Test
    @DisplayName("Test Read Customer Account")
    void readAccount() throws Exception {
        String content = "{\"email\":\"1234@w.com\"}";
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/readAccount")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("1234@w.com"));
    }

    @org.springframework.core.annotation.Order(3)
    @Test
    @DisplayName("Test Update User Information")
    void updateAccount() throws Exception {
        String content = "{\"email\":\"1234@w.com\",\"name\": \"jess\", \"password\": \"1111xxx\", \"phone\": \"12345678\"}";
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/updateAccount")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);
        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("jess"))
                .andExpect(jsonPath("$.password").value("1111xxx"))
                .andExpect(jsonPath("$.phone").value("12345678"));
    }

}
