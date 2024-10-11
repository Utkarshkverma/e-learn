package com.vermau2k01053.course_service.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomMessageDto {

    private String message;
    private boolean success;
    private HttpStatus httpStatus;

}
