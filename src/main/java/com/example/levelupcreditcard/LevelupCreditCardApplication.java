package com.example.levelupcreditcard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LevelupCreditCardApplication {

    public static void main(String[] args) {
        SpringApplication.run(LevelupCreditCardApplication.class, args);
    }

}
