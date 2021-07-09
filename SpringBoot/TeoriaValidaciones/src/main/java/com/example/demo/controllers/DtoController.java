package com.example.demo.controllers;

import com.example.demo.dtos.request.StudentRequestDto;
import com.example.demo.dtos.response.StudentResponseDto;
import com.example.demo.handlers.StudentHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/student")
public class DtoController{

    @PostMapping("/save")
    public ResponseEntity<StudentResponseDto> saveStudent(@Valid @RequestBody StudentRequestDto student){
        StudentResponseDto studentResponseDto = new StudentResponseDto(
                StudentHandler.validateStudent(),
                StudentHandler.saveStudent()
        );

        return new ResponseEntity<>(studentResponseDto, HttpStatus.OK);
    }
}
