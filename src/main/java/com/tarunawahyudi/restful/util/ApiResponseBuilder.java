package com.tarunawahyudi.restful.util;

import com.tarunawahyudi.restful.model.ApiResponse;

public class ApiResponseBuilder {

    public static <T> ApiResponse<T> build(int status, String message, T data) {
        return ApiResponse.<T>builder()
                .status(status)
                .message(message)
                .data(data)
                .build();
    }
}
