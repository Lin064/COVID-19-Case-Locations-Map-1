package com.asd.caselocationsmap;

import com.asd.caselocationsmap.controller.CovidptlController;
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
@WebMvcTest(CovidptlController.class)
public class covidptlControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    CovidptlController CovidptlController;

    @BeforeEach
    void initEach(){
        mockMvc = MockMvcBuilders.standaloneSetup(CovidptlController).build();
        System.out.println("BeforeEach init succeed!");
    }

    @Order (1)
    @Test
    @DisplayName("test create Covid19 Public Test location")
    void createCovidptl() throws Exception {
        String content = "{\"id\":\"1\",\"ptlStreet\":\"2 lachlan St\",\"ptlSuburb\":\"Waterloo\",\"openTime\":\"7\",\"closeTime\":\"9\",\"ptlName\":\"Public Test Place\",\"ptlTel\":\"+61 2 7878 7878\",\"ptlLongitude\":\"3\",\"ptlLatitude\":\"4\"}\n";
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/Covid19_PublicTestLocation2")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.ptlStreet").value("2 lachlan St"));
    }

    @Order (2)
    @Test
    @DisplayName("test read Covid19 Public Test location")
    void readCovidptl() throws Exception {
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/Covid19_PublicTestLocation1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
    }

    @Order (3)
    @Test
    @DisplayName("test update Covid19 Public Test location")
    void updateCovidptl() throws Exception {
        String content = "{\"id\":\"1\",\"ptlStreet\":\"2 lachlan st\",\"ptlSuburb\":\"Waterloo\",\"openTime\":\"7\",\"closeTime\":\"9\",\"ptlName\":\"Public Test Place\",\"ptlTel\":\"+61 2 7878 7878\",\"ptlLongitude\":\"3\",\"ptlLatitude\":\"4\"}\n";
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/Covid19_PublicTestLocation3")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.ptlStreet").value("2 lachlan st"));
    }

    @Order (4)
    @Test
    @DisplayName("test delete Covid19 Public Test location")
    void deleteCovidptl() throws Exception {
        String content = "{\"id\":\"1\",\"ptlStreet\":\"2 lachlan St\",\"ptlSuburb\":\"Waterloo\",\"openTime\":\"7\",\"closeTime\":\"9\",\"ptlName\":\"Public Test Place\",\"ptlTel\":\"+61 2 7878 7878\",\"ptlLongitude\":\"3\",\"ptlLatitude\":\"4\"}\n";        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.delete("/Covid19_PublicTestLocation4")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
    }


}
