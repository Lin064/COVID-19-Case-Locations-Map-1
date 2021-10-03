package com.asd.caselocationsmap;

import com.asd.caselocationsmap.controller.CasesController;
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
@WebMvcTest(CasesController.class)
public class CasesControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    CasesController casesController;

    @BeforeEach
    void initEach(){
        mockMvc = MockMvcBuilders.standaloneSetup(casesController).build();
        System.out.println("BeforeEach init succeed!");
    }

    @Order (1)
    @Test
    @DisplayName("test create case")
    void createCase() throws Exception {
        String content = "{\"id\":\"66ac9dc0-01ab-4b49-b5e8-e707d6010bae\",\"firstName\":\"Hayden\",\"lastName\":\"Rosman\",\"caseDate\":\"2021-09-25T14:00:00.000Z\",\"lastUpdated\":\"2021-09-25T14:00:00.000Z\",\"postcode\":\"2745\",\"suburb\":\"REGENTVILLE\",\"lat\":\"-33.905626\",\"lng\":\"150.645929\",\"location\":\"7 Bette McNee Street\"}\n";
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/cases")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Hayden"));
    }

    @Order (2)
    @Test
    @DisplayName("test read case")
    void readCase() throws Exception {
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/cases")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
    }

    @Order (3)
    @Test
    @DisplayName("test update case")
    void updateCase() throws Exception {
        String content = "{\"id\":\"66ac9dc0-01ab-4b49-b5e8-e707d6010bae\",\"firstName\":\"Archer\",\"lastName\":\"Rosman\",\"caseDate\":\"2021-09-25T14:00:00.000Z\",\"lastUpdated\":\"2021-09-25T14:00:00.000Z\",\"postcode\":\"2745\",\"suburb\":\"REGENTVILLE\",\"lat\":\"-33.905626\",\"lng\":\"150.645929\",\"location\":\"7 Bette McNee Street\"}\n";
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/cases")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Archer"));
    }

    @Order (4)
    @Test
    @DisplayName("test delete case")
    void deleteCase() throws Exception {
        String content = "{\"id\":\"66ac9dc0-01ab-4b49-b5e8-e707d6010bae\",\"firstName\":\"Archer\",\"lastName\":\"Rosman\",\"caseDate\":\"2021-09-25T14:00:00.000Z\",\"lastUpdated\":\"2021-09-25T14:00:00.000Z\",\"postcode\":\"2745\",\"suburb\":\"REGENTVILLE\",\"lat\":\"-33.905626\",\"lng\":\"150.645929\",\"location\":\"7 Bette McNee Street\"}\n";
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.delete("/cases")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
    }


}
