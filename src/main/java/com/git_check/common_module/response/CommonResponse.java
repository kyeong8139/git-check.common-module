package com.git_check.common_module.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Builder;

@Builder
public record CommonResponse<T>(
    int code,
    String message,
    T data
) {
    public static <T> CommonResponse<T> success(ResponseEntity<T> responseEntity) {
        return CommonResponse.<T>builder()
            .code(responseEntity.getStatusCode().value())
            .message("요청이 성공적으로 처리되었습니다.")
            .data(responseEntity.getBody())
            .build();
    }

    public static CommonResponse<Void> fail(HttpStatus status, String message) {
        return CommonResponse.<Void>builder()
            .code(status.value())
            .message(message)
            .data(null)
            .build();
    }
}
