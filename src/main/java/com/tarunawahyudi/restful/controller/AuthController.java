package com.tarunawahyudi.restful.controller;

import com.tarunawahyudi.restful.model.ApiResponse;
import com.tarunawahyudi.restful.model.LoginUserRequest;
import com.tarunawahyudi.restful.model.TokenResponse;
import com.tarunawahyudi.restful.service.AuthService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(
            path = "/api/auth/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ApiResponse<TokenResponse> login(@RequestBody LoginUserRequest request) {
        TokenResponse tokenResponse = authService.login(request);
        return ApiResponse.<TokenResponse>builder().status(1).message("Login success").data(tokenResponse).build();
    }
}
