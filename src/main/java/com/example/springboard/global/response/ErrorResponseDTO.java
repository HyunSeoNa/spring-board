package com.example.springboard.global.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * fileName     : ErrorResponseDTO.java
 * author       : hyunseo
 * date         : 2025. 3. 5.
 * description  : 에러 공통 객체
 */
@Data
@AllArgsConstructor
public class ErrorResponseDTO {
    private String status;
    private String code;
    private String message;

    public static ErrorResponseDTO of(String code, String message) {
        return new ErrorResponseDTO("ERROR", code, message);
    }
}
