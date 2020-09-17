package com.example.racun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.*;

@SpringBootApplication(scanBasePackages = "com.example.racun")
public class RacunApplication {

    public static void main(String[] args) {
        SpringApplication.run(RacunApplication.class, args);
    }

}
