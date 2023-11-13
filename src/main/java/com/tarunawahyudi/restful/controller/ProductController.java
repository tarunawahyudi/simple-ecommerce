package com.tarunawahyudi.restful.controller;

import com.tarunawahyudi.restful.entity.User;
import com.tarunawahyudi.restful.model.ApiResponse;
import com.tarunawahyudi.restful.model.CreateProductRequest;
import com.tarunawahyudi.restful.model.ProductResponse;
import com.tarunawahyudi.restful.service.ProductService;
import com.tarunawahyudi.restful.util.ApiResponseBuilder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping(
            path = "/api/products",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ApiResponse<ProductResponse> create(User user, @RequestBody CreateProductRequest request) {
        try {
            ProductResponse productResponse = service.create(user, request);
            return ApiResponseBuilder.build(1, "OK", productResponse);
        } catch (Exception e) {
            return ApiResponseBuilder.build(0, e.getMessage(), null);
        }
    }

    @GetMapping(
            path = "/api/products/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ApiResponse<ProductResponse> getById(@PathVariable int id) {
        try {
            ProductResponse productResponse = service.get(id);
            return ApiResponseBuilder.build(1, "OK", productResponse);
        } catch (Exception e) {
            return ApiResponseBuilder.build(0, e.getMessage(), null);
        }
    }

    @GetMapping(
            path = "/api/products",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ApiResponse<List<ProductResponse>> getAll() {
        try {
            List<ProductResponse> productResponseList = service.show();
            return ApiResponseBuilder.build(1, "OK", productResponseList);
        } catch (Exception e) {
            return ApiResponseBuilder.build(0, e.getMessage(), null);
        }
    }

    @PutMapping(
            path = "/api/products/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ApiResponse<ProductResponse> put(@PathVariable int id, @RequestBody CreateProductRequest request) {
        try {
            ProductResponse productResponse = service.update(request, id);
            return ApiResponseBuilder.build(1, "OK", productResponse);
        } catch (Exception e) {
            return ApiResponseBuilder.build(0, e.getMessage(), null);
        }

    }

    @DeleteMapping("/api/products/{id}")
    public ApiResponse<ProductResponse> delete(@PathVariable int id) {
        try {
            service.remove(id);
            return ApiResponseBuilder.build(1, "OK", null);
        } catch (Exception e) {
            return ApiResponseBuilder.build(0, e.getMessage(), null);
        }
    }


}
