package com.asd.caselocationsmap;

import com.asd.caselocationsmap.controller.CommentController;
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
@WebMvcTest(CommentController.class)
public class CommentControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    CommentController commentController;

    @BeforeEach
    void initEach(){
        mockMvc = MockMvcBuilders.standaloneSetup(commentController).build();
        System.out.println("BeforeEach init succeed!");
    }

    @Order (1)
    @Test
    @DisplayName("Test Creating Comment")
    void createComment() throws Exception {
        String content = "{\"author\": \"Auto Test\"," +
                          "\"authorType\": \"Admin\"," +
                          "\"context\": \"Test Creating Comment Context\"," +
                          "\"date\": \"2021-10-02\"," +
                          "\"status\": true," +
                          "\"topicId\": 0 }\n";

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/comment2")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.author").value("Auto Test"))
                .andExpect(jsonPath("$.context").value("Test Creating Comment Context"))
                .andExpect(jsonPath("$.date").value("2021-10-02"))
                .andExpect(jsonPath("$.status").value("true"))
                .andExpect(jsonPath("$.authorType").value("Admin"))
                .andExpect(jsonPath("$.topicId").value(0));

    }

    @Order (2)
    @Test
    @DisplayName("Test Reading Comment")
    void readComment() throws Exception {
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/comment1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
    }

    @Order (3)
    @Test
    @DisplayName("Test Updating Comment")
    void updateComment() throws Exception {
        String content = "{\"author\": \"Auto Test\"," +
                "\"id\": 0," +
                "\"context\": \"Test Updating Comment Context\"," +
                "\"date\": \"2021-10-02\"," +
                "\"authorType\": \"Customer\"," +
                "\"status\": true," +
                "\"topicId\": 1 }\n";

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/comment3")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.author").value("Auto Test"))
                .andExpect(jsonPath("$.context").value("Test Updating Comment Context"))
                .andExpect(jsonPath("$.date").value("2021-10-02"))
                .andExpect(jsonPath("$.authorType").value("Customer"))
                .andExpect(jsonPath("$.status").value("true"))
                .andExpect(jsonPath("$.topicId").value(1));
    }

    @Order (4)
    @Test
    @DisplayName("Test Deleting Comment")
    void deleteComment() throws Exception {
        String content = "0";
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/comment4")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
    }


}
