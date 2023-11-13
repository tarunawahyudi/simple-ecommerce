package com.tarunawahyudi.restful.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tarunawahyudi.restful.entity.User;
import com.tarunawahyudi.restful.model.ApiResponse;
import com.tarunawahyudi.restful.model.CreateProductRequest;
import com.tarunawahyudi.restful.model.ProductResponse;
import com.tarunawahyudi.restful.repository.ProductRepository;
import com.tarunawahyudi.restful.repository.UserRepository;
import com.tarunawahyudi.restful.security.BCrypt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {

        User user = new User();
        user.setUsername("taruna");
        user.setPassword(BCrypt.hashpw("taruna", BCrypt.gensalt()));
        user.setName("taruna");
        user.setToken("taruna");
        user.setTokenExpiredAt(System.currentTimeMillis() + 1000000);

        userRepository.save(user);
    }

    @Test
    void createProduct() throws Exception {
        CreateProductRequest request = new CreateProductRequest();
        request.setName("Mouse Logitech");
        request.setDescription("Mouse gaming wireless");
        request.setPrice(10000);

        mockMvc.perform(
                post("/api/products")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            ApiResponse<ProductResponse> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<ApiResponse<ProductResponse>>() {});
            ProductResponse productResponse = response.getData();

            Assertions.assertNotNull(productResponse);
        });
    }

    @Test
    void getProduct() throws Exception {

        mockMvc.perform(
                get("/api/products/20")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            ApiResponse<ProductResponse> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<ApiResponse<ProductResponse>>() {});
            ProductResponse productResponse = response.getData();

            Assertions.assertNotNull(productResponse);
        });
    }

}