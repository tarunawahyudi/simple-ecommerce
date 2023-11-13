package com.tarunawahyudi.restful.controller;

import com.tarunawahyudi.restful.model.ApiResponse;
import com.tarunawahyudi.restful.model.RegisterUserRequest;
import com.tarunawahyudi.restful.model.UserResponse;
import com.tarunawahyudi.restful.service.UserService;
import com.tarunawahyudi.restful.util.ApiResponseBuilder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(
            path = "/api/users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ApiResponse<UserResponse> register(@RequestBody RegisterUserRequest request) {
        try {
            userService.register(request);
            return ApiResponseBuilder.build(1, "OK", null);
        } catch (Exception e) {
            return ApiResponseBuilder.build(0, e.getMessage(), null);
        }
    }
}
