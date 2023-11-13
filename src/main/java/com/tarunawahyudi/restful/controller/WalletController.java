package com.tarunawahyudi.restful.controller;

import com.tarunawahyudi.restful.entity.User;
import com.tarunawahyudi.restful.model.ApiResponse;
import com.tarunawahyudi.restful.model.CreateWalletRequest;
import com.tarunawahyudi.restful.model.WalletResponse;
import com.tarunawahyudi.restful.service.WalletService;
import com.tarunawahyudi.restful.util.ApiResponseBuilder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WalletController {

    private final WalletService service;

    public WalletController(WalletService service) {
        this.service = service;
    }

    @PostMapping(
            path = "/api/wallets",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ApiResponse<WalletResponse> create(User user, @RequestBody CreateWalletRequest request) {
        try {
            WalletResponse WalletResponse = service.create(user, request);
            return ApiResponseBuilder.build(1, "OK", WalletResponse);
        } catch (Exception e) {
            return ApiResponseBuilder.build(0, e.getMessage(), null);
        }
    }

    @GetMapping(
            path = "/api/wallets/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ApiResponse<WalletResponse> getById(@PathVariable int id) {
        try {
            WalletResponse WalletResponse = service.get(id);
            return ApiResponseBuilder.build(1, "OK", WalletResponse);
        } catch (Exception e) {
            return ApiResponseBuilder.build(0, e.getMessage(), null);
        }
    }

    @GetMapping(
            path = "/api/wallets",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ApiResponse<List<WalletResponse>> getAll() {
        try {
            List<WalletResponse> WalletResponseList = service.show();
            return ApiResponseBuilder.build(1, "OK", WalletResponseList);
        } catch (Exception e) {
            return ApiResponseBuilder.build(0, e.getMessage(), null);
        }
    }

    @PutMapping(
            path = "/api/wallets/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ApiResponse<WalletResponse> put(@PathVariable int id, @RequestBody CreateWalletRequest request) {
        try {
            WalletResponse WalletResponse = service.update(request, id);
            return ApiResponseBuilder.build(1, "OK", WalletResponse);
        } catch (Exception e) {
            return ApiResponseBuilder.build(0, e.getMessage(), null);
        }

    }

    @DeleteMapping("/api/wallets/{id}")
    public ApiResponse<WalletResponse> delete(@PathVariable int id) {
        try {
            service.remove(id);
            return ApiResponseBuilder.build(1, "OK", null);
        } catch (Exception e) {
            return ApiResponseBuilder.build(0, e.getMessage(), null);
        }
    }

}
