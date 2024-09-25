package com.vermau2k01053.category_service.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponseDto {

    private String apiPath;
    private String message;
    private HttpStatus httpStatus;
    private LocalDateTime timestamp;
}
