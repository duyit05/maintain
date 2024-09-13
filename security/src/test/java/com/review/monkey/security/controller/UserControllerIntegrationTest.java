package com.review.monkey.security.controller;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.review.monkey.security.request.UserRequest;
import com.review.monkey.security.response.UserResponse;
import com.review.monkey.security.service.UserService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
// Mock request to controller
@AutoConfigureMockMvc

// FOR USING INTEGRATION TEST
@Testcontainers
public class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Container
    static final MySQLContainer<?> MY_SQL_CONTAINER = new MySQLContainer<>("mysql:latest");

    @DynamicPropertySource
    static void configureDatesource(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", MY_SQL_CONTAINER::getJdbcUrl);
        registry.add("spring.datasource.username", MY_SQL_CONTAINER::getUsername);
        registry.add("spring.datasource.password", MY_SQL_CONTAINER::getPassword);
        registry.add("spring.datasource.driverClassName", () -> "com.mysql.cj.jdbc.Driver");
        registry.add("spring.jpa.hibernate.ddl-auto", () -> "update");
    }

    private UserRequest request;
    private UserResponse response;
    private LocalDate dob;

    // start befor test
    @BeforeEach
    public void intData() {
        dob = LocalDate.of(1990, 1, 1);
        request = UserRequest.builder()
                .username("john biden")
                .firstName("john biden")
                .lastName("john biden")
                .password("12345678")
                .dob(dob)
                .build();

        response = UserResponse.builder()
                .userId("46f0-b7a8")
                .username("john biden")
                .firstName("john biden")
                .lastName("john biden")
                .dob(dob)
                .build();
    }

    @Test
    void createUser_validRequest_success() throws Exception {
        // GIVE (request , response)
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        // convert string to json
        String content = objectMapper.writeValueAsString(request);

        // request api and resopnse data in controller , avoid call floor service
        Mockito.when(userService.createUser(ArgumentMatchers.any())).thenReturn(response);

        // WHEN (request api)
        var response = mockMvc.perform(MockMvcRequestBuilders.post("/user")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(content))
                // THEN (what expected)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("code").value(1000))
                .andExpect(MockMvcResultMatchers.jsonPath("result.username").value("john biden"))
                .andExpect(MockMvcResultMatchers.jsonPath("result.firstName").value("john biden"))
                .andExpect(MockMvcResultMatchers.jsonPath("result.lastName").value("john biden"));

        log.info("Result : {}", response.andReturn().getResponse().getContentAsString());
    }
}
