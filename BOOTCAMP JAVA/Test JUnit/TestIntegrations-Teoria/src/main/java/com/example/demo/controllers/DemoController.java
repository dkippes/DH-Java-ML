package com.example.demo.controllers;

import com.example.demo.dtos.HelloDTO;
import com.example.demo.dtos.StudentTestDTO;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController{

    @GetMapping("/sayHello")
    public StudentTestDTO sayStudent(){
        return new StudentTestDTO(1L, "Hello World!");
    }

    @GetMapping("/sayHello/{name}")
    public StudentTestDTO sayStudentPathVariable(@PathVariable String name){
        return new StudentTestDTO(1L,  "Hello "+ name +"!" );
    }

    @GetMapping("/sayHelloWithParam")
    public StudentTestDTO sayStudentQueryParam(@RequestParam String name){
        return new StudentTestDTO(1L,  "Hello "+ name +"!" );
    }

    @GetMapping("/sayHelloWithMultiParams")
    public StudentTestDTO sayHelloWithMultiParams(@RequestParam Long id, @RequestParam String name){
        return new StudentTestDTO(id,  "Hello "+ name +"!" );
    }

    @PostMapping("/sayHelloPost")
    public StudentTestDTO sendPost(@RequestBody HelloDTO myObj){
        return new StudentTestDTO(myObj.getId(),  "Hello "+ myObj.getName() +" by POST!" );
    }

}
