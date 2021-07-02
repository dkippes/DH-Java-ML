package com.example.demo.models;

// Con lombok es como poder poner todo los constructores y getters and setters
import lombok.*;

@Data // Getter and setter, compareString etc
@AllArgsConstructor // Te pone to dos los constructores
@NoArgsConstructor // Constructore sin argumentos
public class Greeting {
    private long id;
    private String context;
    private String className;
}