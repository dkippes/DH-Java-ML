package com.example.numerosromanos;

import com.example.numerosromanos.controllers.NumeroRomanoController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NumerosRomanosApplication {

    public static void main(String[] args) {

        SpringApplication.run(NumerosRomanosApplication.class, args);
        NumeroRomanoController numero = new NumeroRomanoController();
    }

}
