package com.example.springboard.global.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * fileName     : ResponseDTO.java
 * author       : hyunseo
 * date         : 2025. 3. 5.
 * description  : 응답 객체
 */
@Data
@AllArgsConstructor
public class ResponseDTO<T> {
    private String status;
    private String message;
    private T data;

    public static <T> ResponseDTO<T> success(String message, T data) {
        return new ResponseDTO<>("SUCCESS", message, data);
    }

    public static <T> ResponseDTO<T> success(String message) {
        return new ResponseDTO<>("SUCCESS", message, null);
    }
}
