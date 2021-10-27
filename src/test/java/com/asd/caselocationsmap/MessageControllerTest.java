package com.asd.caselocationsmap;

import com.asd.caselocationsmap.controller.MessageController;
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
@WebMvcTest(MessageController.class)
public class MessageControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    MessageController messageController;

    @BeforeEach
    void initEach(){
        mockMvc = MockMvcBuilders.standaloneSetup(messageController).build();
        System.out.println("BeforeEach init succeed!");
    }

    @Order (1)
    @Test
    @DisplayName("Test Creating Message")
    void createMessage() throws Exception {
        String content = "{\"author\": \"Auto Test\"," +
                          "\"authorType\": \"Customer\"," +
                          "\"context\": \"Test Creating Message Context\"," +
                          "\"date\": \"2021-10-02\"," +
                          "\"tag\": \"Test Creating Message Tag\"," +
                          "\"status\": true," +
                          "\"title\": \"Test Creating Message Title\"," +
                          "\"type\": \"discussion\"}\n";

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/topic2")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.author").value("Auto Test"))
                .andExpect(jsonPath("$.authorType").value("Customer"))
                .andExpect(jsonPath("$.context").value("Test Creating Message Context"))
                .andExpect(jsonPath("$.date").value("2021-10-02"))
                .andExpect(jsonPath("$.tag").value("Test Creating Message Tag"))
                .andExpect(jsonPath("$.status").value("true"))
                .andExpect(jsonPath("$.title").value("Test Creating Message Title"))
                .andExpect(jsonPath("$.type").value("discussion"));

    }

    @Order (2)
    @Test
    @DisplayName("Test Reading Message")
    void readMessage() throws Exception {
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/topic1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
    }

    @Order (3)
    @Test
    @DisplayName("Test Updating Message")
    void updateMessage() throws Exception {
        String content = "{\"author\": \"Auto Test\"," +
                "\"id\": 0," +
                "\"authorType\": \"Admin\"," +
                "\"context\": \"Test Updating Message Context\"," +
                "\"date\": \"2021-10-02\"," +
                "\"tag\": \"Test Updating Message Tag\"," +
                "\"status\": true," +
                "\"title\": \"Test Updating Message Title\"," +
                "\"type\": \"discussion\"}\n";

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/topic3")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.author").value("Auto Test"))
                .andExpect(jsonPath("$.authorType").value("Admin"))
                .andExpect(jsonPath("$.context").value("Test Updating Message Context"))
                .andExpect(jsonPath("$.date").value("2021-10-02"))
                .andExpect(jsonPath("$.tag").value("Test Updating Message Tag"))
                .andExpect(jsonPath("$.status").value("true"))
                .andExpect(jsonPath("$.title").value("Test Updating Message Title"))
                .andExpect(jsonPath("$.type").value("discussion"));
    }

    @Order (4)
    @Test
    @DisplayName("Test Deleting Message")
    void deleteMessage() throws Exception {
        String content = "0";
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/topic4")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
    }


}
