package com.git_check.common_module.response;

import org.springframework.http.HttpStatus;

import lombok.Builder;

@Builder
public record CommonResponse<T>(
    int code,
    String message,
    T data
) {
    public static <T> CommonResponse<T> success(T data, String message) {
        return CommonResponse.<T>builder()
            .code(HttpStatus.OK.value())
            .message(message)
            .data(data)
            .build();
    }

    
    public static <T> CommonResponse<T> success(String message) {
        return CommonResponse.<T>builder()
            .code(HttpStatus.OK.value())
            .message(message)
            .data(null)
            .build();
    }

    public static CommonResponse<Void> fail(HttpStatus status, String message) {
        return CommonResponse.<Void>builder()
            .code(status.value())
            .message(message)
            .data(null)
            .build();
    }

    public static CommonResponse<Void> except() {
        return CommonResponse.<Void>builder()
            .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .message("서버 내부 오류가 발생했습니다.")
            .data(null)
            .build();
    }
}
