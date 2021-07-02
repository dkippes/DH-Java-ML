package com.example.codigomorse;

import com.example.codigomorse.models.CodigoMorse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodigoMorseApplication {

    public static void main(String[] args) {

        SpringApplication.run(CodigoMorseApplication.class, args);
        CodigoMorse as = new CodigoMorse();
    }

}
