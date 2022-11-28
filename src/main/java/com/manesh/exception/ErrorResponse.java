package com.manesh.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    private LocalDateTime timestamp;
    private String message;
    private List<String> fieldErrors = new ArrayList<>();

}
