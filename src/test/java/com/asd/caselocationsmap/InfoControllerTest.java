package com.asd.caselocationsmap;

import com.asd.caselocationsmap.controller.InfoController;
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
@WebMvcTest(InfoController.class)
public class InfoControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    InfoController infoController;

    @BeforeEach
    void initEach(){
        mockMvc = MockMvcBuilders.standaloneSetup(infoController).build();
        System.out.println("BeforeEach init succeed!");
    }

    @Order (1)
    @Test
    @DisplayName("Test Creating information")
    void createInfo() throws Exception {
        String content = "{\"author\": \"Auto Test\"," +
                          "\"context\": \"Test Creating Information Context\"," +
                          "\"date\": \"2021-10-02\"," +
                          "\"description\": \"Test Creating Information Description\"," +
                          "\"status\": true," +
                          "\"title\": \"Test Creating Information Title\"," +
                          "\"type\": \"COVID-19 News\"}\n";

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/info2")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.author").value("Auto Test"))
                .andExpect(jsonPath("$.context").value("Test Creating Information Context"))
                .andExpect(jsonPath("$.date").value("2021-10-02"))
                .andExpect(jsonPath("$.description").value("Test Creating Information Description"))
                .andExpect(jsonPath("$.status").value("true"))
                .andExpect(jsonPath("$.title").value("Test Creating Information Title"))
                .andExpect(jsonPath("$.type").value("COVID-19 News"));

    }

    @Order (2)
    @Test
    @DisplayName("Test Reading Information")
    void readInfo() throws Exception {
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/info1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
    }

    @Order (3)
    @Test
    @DisplayName("Test Updating Information")
    void updateInfo() throws Exception {
        String content = "{\"author\": \"Auto Test\"," +
                "\"id\": 0," +
                "\"context\": \"Test Updating Information Context\"," +
                "\"date\": \"2021-10-02\"," +
                "\"description\": \"Test Updating Information Description\"," +
                "\"status\": true," +
                "\"title\": \"Test Updating Information Title\"," +
                "\"type\": \"COVID-19 News\"}\n";

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/info3")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.author").value("Auto Test"))
                .andExpect(jsonPath("$.context").value("Test Updating Information Context"))
                .andExpect(jsonPath("$.date").value("2021-10-02"))
                .andExpect(jsonPath("$.description").value("Test Updating Information Description"))
                .andExpect(jsonPath("$.status").value("true"))
                .andExpect(jsonPath("$.title").value("Test Updating Information Title"))
                .andExpect(jsonPath("$.type").value("COVID-19 News"));
    }

    @Order (4)
    @Test
    @DisplayName("Test Deleting Information")
    void deleteInfo() throws Exception {
        String content = "0";
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/info4")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
    }


}
