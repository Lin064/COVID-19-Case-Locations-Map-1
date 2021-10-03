package com.asd.caselocationsmap;

import com.asd.caselocationsmap.controller.VaccController;
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
@WebMvcTest(VaccController.class)
public class VaccControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    VaccController VaccController;

    @BeforeEach
    void initEach(){
        mockMvc = MockMvcBuilders.standaloneSetup(VaccController).build();
        System.out.println("BeforeEach init succeed!");
    }

    @Order (1)
    @Test
    @DisplayName("test create VaccInjectLocation")
    void createVaccInjectlocation() throws Exception {
        String content = "{\"id\":\"71\",\"vaccStreet\":\"406 Victoria St\",\"vaccSuburb\":\"Darlinghurst\",\"isAvailable\":\"No\",\"remainingVaccine\":\"3224\",\"locationName\":\"VinPriv Hospital\",\"bookingWebsite\":\"www.vinPriv.com\",\"bookingTel\":\"+61 2 8382 7111\",\"locationLongitude\":\"3\",\"locationLatitude\":\"4\"}\n";
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/VaccInjectLocation2")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.vaccStreet").value("406 Victoria St"));
    }

    @Order (2)
    @Test
    @DisplayName("test read VaccInjectLocation")
    void readVaccInjectLocation() throws Exception {
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/VaccInjectLocation1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
    }

    @Order (3)
    @Test
    @DisplayName("test update VaccInjectLocation")
    void updateVaccInjectLocation() throws Exception {
        String content = "{\"id\":\"71\",\"vaccStreet\":\"406 Victoria St\",\"vaccSuburb\":\"Darlinghurst\",\"isAvailable\":\"No\",\"remainingVaccine\":\"3224\",\"locationName\":\"VinPriv Hospital\",\"bookingWebsite\":\"www.vinPriv.com\",\"bookingTel\":\"+61 2 8382 7111\",\"locationLongitude\":\"3\",\"locationLatitude\":\"4\"}\n";
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/VaccInjectLocation3")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.vaccStreet").value("406 Victoria St"));
    }

    @Order (4)
    @Test
    @DisplayName("test delete VaccInjectLocation")
    void deleteVaccInjectLocation() throws Exception {
        String content = "{\"id\":\"71\",\"vaccStreet\":\"406 Victoria St\",\"vaccSuburb\":\"Darlinghurst\",\"isAvailable\":\"No\",\"remainingVaccine\":\"3224\",\"locationName\":\"VinPriv Hospital\",\"bookingWebsite\":\"www.vinPriv.com\",\"bookingTel\":\"+61 2 8382 7111\",\"locationLongitude\":\"3\",\"locationLatitude\":\"4\"}\n";        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.delete("/VaccInjectLocation4")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
    }


}
