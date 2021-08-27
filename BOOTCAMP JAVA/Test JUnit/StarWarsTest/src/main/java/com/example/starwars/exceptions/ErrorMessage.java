package com.example.starwars.exceptions;

import lombok.*;

import java.util.Map;

@AllArgsConstructor
@Getter
public class ErrorMessage {

    private Integer status;
    private String error;
    private Map<String, String> message;

}
