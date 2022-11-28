package com.example.firstProject.demo;

import lombok.Data;

@Data
public class GenericResponse {
    String result;
    String errorCode;
    String errorMessage;
}
